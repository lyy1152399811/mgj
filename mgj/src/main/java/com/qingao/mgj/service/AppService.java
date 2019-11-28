package com.qingao.mgj.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingao.mgj.exception.LogNameIsNotExistException;
import com.qingao.mgj.exception.PasswordErrorException;
import com.qingao.mgj.exception.UserIsDisabledException;
import com.qingao.mgj.mapper.App_AreaInfo_Mapper;
import com.qingao.mgj.mapper.App_Cart_Mapper;
import com.qingao.mgj.mapper.App_GoodsInfo_Mapper;
import com.qingao.mgj.mapper.App_OrderList_Mapper;
import com.qingao.mgj.mapper.AreainfoMapper;
import com.qingao.mgj.mapper.CartMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodssizeMapper;
import com.qingao.mgj.mapper.OrderinfoMapper;
import com.qingao.mgj.mapper.OrderlistMapper;
import com.qingao.mgj.mapper.UserMapper;
import com.qingao.mgj.pojo.Areainfo;
import com.qingao.mgj.pojo.AreainfoExample;
import com.qingao.mgj.pojo.Cart;
import com.qingao.mgj.pojo.CartExample;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.GoodsinfoExample;
import com.qingao.mgj.pojo.Goodssize;
import com.qingao.mgj.pojo.GoodssizeExample;
import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.OrderinfoExample;
import com.qingao.mgj.pojo.Orderlist;
import com.qingao.mgj.pojo.User;
import com.qingao.mgj.pojo.UserExample;

@Service
public class AppService {

	@Autowired
	AreainfoMapper areainfoMapper;

	@Autowired
	App_AreaInfo_Mapper app_AreaInfo_Mapper;

	@Autowired
	App_GoodsInfo_Mapper app_GoodsInfo_Mapper;

	@Autowired
	GoodsinfoMapper goodsinfoMapper;

	@Autowired
	GoodssizeMapper goodssizeMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	CartMapper cartMapper;

	@Autowired
	App_Cart_Mapper app_Cart_Mapper;

	@Autowired
	OrderinfoMapper orderinfoMapper;

	@Autowired
	OrderlistMapper orderlistMapper;

	@Autowired
	App_OrderList_Mapper app_OrderList_Mapper;

	
	
	 
	/**
	 * 获取所有用户订单
	 * @param userid
	 * @param ofstate
	 * @return
	 */
	public List<Orderinfo> getOrderInformationsByUserID(Integer userid,Integer ofstate){
		
		OrderinfoExample example=new OrderinfoExample();
		example.createCriteria().andUseridEqualTo(userid).andOfstateEqualTo(ofstate);
		
		example.setOrderByClause("ofdate desc");
		
		return orderinfoMapper.selectByExample(example);
	}
	
	
	
	
	/**
	 * 生成订单
	 * @param orderinfo 订单对象
	 * @param ctids 要操作的购物车id列表
	 */
	@Transactional
	public void mkOrderInfo(Orderinfo orderinfo, List<Integer> ctids) {

		String ofid = UUID.randomUUID().toString();
		orderinfo.setOfid(ofid);
		orderinfo.setOfstate(1);
		orderinfo.setOfdate(new Date());

		orderinfoMapper.insert(orderinfo);

		List<Orderlist> list = app_OrderList_Mapper.getOrderLists(ctids);

		for (int i = 0; i < list.size(); i++) {

			Orderlist ol = list.get(i);
			ol.setOlid(new StringBuffer(ofid).append("_").append(i+1).toString());
			ol.setOfid(ofid);

			orderlistMapper.insert(ol);
		}

	}

	/**
	 * 获取用户购物车信息
	 * @param userid
	 * @return
	 */
	public List<Map> getCartListByUserID(Integer userid) {
		return app_Cart_Mapper.getCartListByUserID(userid);
	}

	
	/**
	 * 购物车数量微调
	 * @param cart
	 */
	@Transactional
	public void changeCountForCart(Cart cart) {

		if (cart.getGdcount() <= 0) {
			cartMapper.deleteByPrimaryKey(cart.getCtid());
		} else {
			cartMapper.updateByPrimaryKeySelective(cart);

		}

	}

	/**
	 * 添加购物车信息
	 * @param cart
	 */
	@Transactional
	public void addToCart(Cart cart) {
		CartExample example = new CartExample();
		example.createCriteria().andGdidEqualTo(cart.getGdid()).andGsidEqualTo(cart.getGsid())
				.andUseridEqualTo(cart.getUserid());

		List<Cart> cartItems = cartMapper.selectByExample(example);
		if (cartItems != null && cartItems.size() == 1) {

			Cart ct = cartItems.get(0);
			ct.setGdcount(ct.getGdcount() + cart.getGdcount());
			cartMapper.updateByPrimaryKey(ct);

		} else {
			cartMapper.insert(cart);
		}

	}

	/**
	 * 用户登陆方法
	 * 
	 * @param logname
	 *            用户名
	 * @param password
	 *            密码（原文）
	 * @return 用户完整对象（User）表示 登陆成功
	 * @throws LogNameIsNotExistException
	 *             用户名不存在
	 * @throws UserIsDisabledException
	 *             用户状态异常（如禁用等）
	 * @throws PasswordErrorException
	 *             密码错误
	 */
	public User login(String logname, String password)
			throws LogNameIsNotExistException, UserIsDisabledException, PasswordErrorException {
		UserExample example = new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			throw new LogNameIsNotExistException();
		}
		User user = list.get(0);
		if (user.getStatus() == 0) {
			throw new UserIsDisabledException();
		}
		String client_password = new Md5Hash(password, user.getSalt()).toString();
		if (!client_password.equals(user.getPassword())) {
			throw new PasswordErrorException();
		}
		return user;
	}

	/**
	 * 验证用户名是否以及被注册的方法
	 * 
	 * @param logname
	 * @return
	 */
	public boolean userNameAlreadyUsed(String logname) {

		UserExample example = new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		return userMapper.countByExample(example) == 1;

	}

	/**
	 * 进行用户信息注册的方法
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public boolean doRegedit(User user) {

		String pwd_source = user.getPassword();

		String salt = UUID.randomUUID().toString();

		user.setPassword(new Md5Hash(pwd_source, salt).toString());
		user.setSalt(salt);
		user.setStatus(1);
		user.setUtid(1);

		return userMapper.insert(user) == 1;

	}

	/**
	 * 获取说有商品尺寸信息
	 * 
	 * @return
	 */
	public List<Goodssize> getAllGoodsSize() {

		GoodssizeExample example = new GoodssizeExample();
		return goodssizeMapper.selectByExample(example);
	}

	/**
	 * 根据编号获取商品明细信息
	 * 
	 * @param gdid
	 * @return
	 */
	public Map getGoodsInfo_Detail_ByGdid(Integer gdid) {
		return app_GoodsInfo_Mapper.getGoodsDetailByGdid(gdid);
	}

	/**
	 * 根据关键字获取信息名称前十位
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Goodsinfo> getGoodsInfoByKeywords_Top10(String keyword) {

		GoodsinfoExample example = new GoodsinfoExample();

		example.createCriteria().andGdnameLike("%" + keyword + "%");
		example.setOrderByClause(" gtdate desc");
		;

		RowBounds rowBounds = new RowBounds(0, 10);
		return goodsinfoMapper.selectByExampleWithRowbounds(example, rowBounds);

	}

	/**
	 * 获取商品瀑布流分页数量
	 * 
	 * @param rowCount
	 * @return
	 */
	public Integer getPageCount_GoodsInfo(Integer rowCount) {

		GoodsinfoExample example = new GoodsinfoExample();

		example.createCriteria().andGdidLessThanOrEqualTo(100);

		Integer count = (int) goodsinfoMapper.countByExample(example);

		return (count % rowCount == 0 ? count / rowCount : (count / rowCount) + 1);

	}

	public List<Map> getGoodsInfoes(Integer rowCount, Integer pageNum) {

		GoodsinfoExample example = new GoodsinfoExample();
		RowBounds rowBounds = new RowBounds((pageNum - 1) * rowCount, rowCount);
		return app_GoodsInfo_Mapper.getGoodsInformations(example, rowBounds);

	}

	/**
	 * 根据指定编号获取地区信息对象
	 * 
	 * @param aid
	 *            主键
	 * @return
	 */
	public Areainfo getAreaInfoByAid(Integer aid) {
		return areainfoMapper.selectByPrimaryKey(aid);
	}

	/**
	 * 根据主键更新指定地区信息
	 * 
	 * @param areainfo
	 * @return
	 */
	@Transactional
	public boolean doUpdate_AreaInfo(Areainfo areainfo) {
		return areainfoMapper.updateByPrimaryKey(areainfo) == 1;
	}

	@Transactional
	public boolean doInsert_AreaInfo(Areainfo areainfo) {

		return areainfoMapper.insert(areainfo) == 1;

	}

	/**
	 * 获取全部地区信息
	 * 
	 * @return
	 */
	public List<Areainfo> getAllAreaInfoes() {

		AreainfoExample example = new AreainfoExample();
		return areainfoMapper.selectByExample(example);

	}

	/**
	 * 根据指定行政级别返回地区
	 * 
	 * @param level
	 *            行政级别编号
	 * @return
	 */
	public List<Areainfo> getAreaInfoesByLevel(Integer level) {

		AreainfoExample example = new AreainfoExample();
		example.createCriteria().andAlevelEqualTo(level);

		return areainfoMapper.selectByExample(example);

	}

	/**
	 * 根据编号删除指定地区信息
	 * 
	 * @param aid
	 *            编号
	 * @return
	 */
	@Transactional
	public boolean deleteAreaInfoByAid(Integer aid) {

		return areainfoMapper.deleteByPrimaryKey(aid) == 1;

	}

	/**
	 * 根据指定行数 获取 分页的总页面数量
	 * 
	 * @param rowCount
	 *            指定每页行数
	 * @return 页数
	 */
	public Integer getPageCount(Integer rowCount) {
		AreainfoExample example = new AreainfoExample();

		Long records = areainfoMapper.countByExample(example);

		return (int) ((records % rowCount) == 0 ? records / rowCount : (records / rowCount) + 1);

	}

	/**
	 * 根据每页行数 和 页面 获取指定信息
	 * 
	 * @param rowCount
	 *            每页行数
	 * @param pageNum
	 *            指定页码
	 * @return 数据封装的list集合
	 */
	public List<Map> getAreaInfoes(Integer rowCount, Integer pageNum) {

		AreainfoExample example = new AreainfoExample();

		int offset = (pageNum - 1) * rowCount;

		RowBounds rowBounds = new RowBounds(offset, rowCount);

		return app_AreaInfo_Mapper.getAreaInformations(example, rowBounds);

	}

}
