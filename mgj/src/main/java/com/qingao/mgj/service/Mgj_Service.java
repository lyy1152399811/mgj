package com.qingao.mgj.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.crypto.hash.Md5Hash;
import com.qingao.mgj.pojo.Goodsinfo;

import com.qingao.mgj.pojo.Goodssize;
import com.qingao.mgj.pojo.GoodssizeExample;

import com.qingao.mgj.exception.NotFoundLognameException;
import com.qingao.mgj.exception.PasswordErrorException;
import com.qingao.mgj.exception.UserStatusException;
import com.qingao.mgj.pojo.User;
import com.qingao.mgj.pojo.UserExample;

import com.qingao.mgj.pojo.Cart;

import com.qingao.mgj.mapper.Cart_Mapper;

import com.qingao.mgj.pojo.OrderinfoExample;

import com.qingao.mgj.pojo.CartExample;

import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodssizeMapper;
import com.qingao.mgj.pojo.GoodsinfoExample;

import com.qingao.mgj.mapper.App_Goodsimage_Mapper;
import com.qingao.mgj.mapper.CartMapper;
import com.qingao.mgj.pojo.GoodsimageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingao.mgj.mapper.GoodscollectionMapper;
import com.qingao.mgj.mapper.OrderinfoMapper;
import com.qingao.mgj.mapper.OrderlistMapper;
import com.qingao.mgj.mapper.UserMapper;
import com.qingao.mgj.mapper.UserinfoMapper;
import com.qingao.mgj.pojo.GoodscollectionExample;
import com.qingao.mgj.pojo.GoodscollectionKey;
import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.Orderlist;
import com.qingao.mgj.pojo.OrderlistExample;

@Service
public class Mgj_Service {

	@Autowired
	private GoodscollectionMapper collection;
	
	@Autowired
	private OrderinfoMapper orderinfo;
	
	@Autowired
	private GoodsinfoMapper goodsinfo;
	
	@Autowired
	private OrderlistMapper orderlist;
	
	@Autowired
	private App_Goodsimage_Mapper goodsimage;
	
	@Autowired
	private CartMapper carts;
	
	@Autowired
	private Cart_Mapper cartw;
	
	@Autowired
	private UserMapper user;
	
	@Autowired
	private GoodssizeMapper goodssize;
	
	/*
	 * 查询该user是否已收藏该商品，若未收藏则收藏，若已收藏则取消收藏
	 */
	@Transactional
	public void goodscollection(int gdid,int userid){
			
		GoodscollectionExample example=new GoodscollectionExample();
		example.createCriteria().andGdidEqualTo(gdid).andUseridEqualTo(userid);
		
		if(collection.countByExample(example)==1){
			collection.deleteByExample(example);
		}else{
			GoodscollectionKey goodscollection=new GoodscollectionKey();
			goodscollection.setGdid(gdid);
			goodscollection.setUserid(userid);
			collection.insert(goodscollection);
		}			
	}
	
	/*
	 * 查询某商品被的收藏次数
	 */
	public long goodscollectioncount(int gdid){
		GoodscollectionExample example=new GoodscollectionExample();
		example.createCriteria().andGdidEqualTo(gdid);		
		return collection.countByExample(example);
	}
	
	/*
	 * 查询user收藏过哪些商品，返回GoodscollectionKey类型集合
	 */
	public List<GoodscollectionKey> changecolor(int userid){
		GoodscollectionExample example=new GoodscollectionExample();
		example.createCriteria().andUseridEqualTo(userid);
		List<GoodscollectionKey> key=collection.selectByExample(example);
		return key;
	}
	
	/*
	 * 客户订单管理，商户登陆后有订单就处理，没有不弹出（点击发货），通过商户登录实现.
	 */
	public List<Map> DeliverGoods(int stid){
		return orderinfo.selectfororderinfo(stid);
	}
	
	/*
	 * 点击发货，删除待发货商品。
	 */
	public void DeleteDeliverGoods(String olid,String ofid){
			
		Orderlist record1=new Orderlist();
		record1.setOlid(olid);
		OrderlistExample example1=new OrderlistExample();
		example1.createCriteria().andOlidEqualTo(olid+"+");
		orderlist.updateByExampleSelective(record1, example1);
		OrderlistExample example=new OrderlistExample();
		example.createCriteria().andOfidEqualTo(ofid).andOlidNotLike("%+%");
		if(orderlist.selectByExample(example).size()==0){
			Orderinfo record=new Orderinfo();
			record.setOfid(ofid);
			record.setOfstate(3);
			orderinfo.updateByPrimaryKeySelective(record);
		}
	}
	
	/*
	 * 商品图片瀑布流
	 */
	public List<Map> getAllGoodsimageForAjax(int pagenum){
		
		GoodsimageExample example=new GoodsimageExample();
		int number=pagenum;
		int limit=16;
		int offset=(number-1)*limit;		
		RowBounds rowBounds=new RowBounds(offset, limit);
		return goodsimage.getAllGoodsimage(example, rowBounds);
	}
	
	/*
	 * 得到瀑布流页数
	 */
	public int getGoodsinfoesCount(){
		GoodsinfoExample example=new GoodsinfoExample();
		return (int) (goodsinfo.countByExample(example)%16==0?goodsinfo.countByExample(example)/16:(goodsinfo.countByExample(example)/16)+1);
		 
	}
	
	/*
	 * 显示商品被收藏次数
	 */	
	public List<Map> getcollectionforajax(int pagenum){
		
		GoodscollectionExample example=new GoodscollectionExample();
		int number=pagenum;
		int limit=16;
		int offset=(number-1)*limit;		
		RowBounds rowBounds=new RowBounds(offset, limit);
		return collection.selectallcollection(example, rowBounds);
	}
	
	/*
	 * 付款界面信息
	 */
	public List<Orderlist> selectOrderListByOfid(String ofid){
		OrderlistExample example=new OrderlistExample();
		example.createCriteria().andOfidEqualTo(ofid);
		return orderlist.selectByExample(example);
	}
	
	/*
	 * 付款成功后订单状态改为2
	 */
	@Transactional
	public void paydone11(String ofid){
		Orderinfo record=new Orderinfo();
		record.setOfid(ofid);
		record.setOfstate(2);
		orderinfo.updateByPrimaryKeySelective(record);
	}
	
	/*
	 * 付款成功后删除购物车对应商品
	 */
	@Transactional
	public void delectcart(int gdid,int gsid,int userid){
		
		CartExample example=new CartExample();
		example.createCriteria().andGdidEqualTo(gdid).andGsidEqualTo(gsid).andUseridEqualTo(userid);
		carts.deleteByExample(example);
	}
	
	/*
	 * 通过用户ID查询订单信息
	 */
	public List<Orderinfo> selectOrderinfobyuserid(int userid){		
		OrderinfoExample example=new OrderinfoExample();
		example.createCriteria().andUseridEqualTo(userid).andOfstateEqualTo(1);
		return orderinfo.selectByExample(example);
	}
	
	/*
	 * 生成订单信息
	 */
	@Transactional
	public void insertOrder(int userid,String address,String contactnumber,String recipient, List<Integer> ctid){
		Orderinfo Order=new Orderinfo();
		Order.setOfdate(new Date());
		Order.setOfstate(1);
		Order.setOfid(UUID.randomUUID().toString());
		Order.setUserid(userid);
		Order.setAddress(address);
		Order.setContactnumber(contactnumber);
		Order.setRecipient(recipient);
		orderinfo.insert(Order);
		
		List<Map> list=cartw.getCartForOrder(ctid);
		for(int i=0;i<list.size();i++){
			Orderlist orderlist1=new Orderlist();
			orderlist1.setGdcount((int)list.get(i).get("gdcount"));
			orderlist1.setGdid((int)list.get(i).get("gdid"));
			orderlist1.setGsid((int)list.get(i).get("gsid"));
			orderlist1.setPrice((Double)list.get(i).get("price"));
			orderlist1.setOfid(Order.getOfid());
			orderlist1.setOlid(Order.getOfid()+"_"+(i+1));
			orderlist.insert(orderlist1);
		}
	}
	
	/*
	 * 清除用户购物车里的某一个商品
	 */
	@Transactional
	public void deleteCart(int ctid){
		carts.deleteByPrimaryKey(ctid);
	}
	
	/*
	 * 购物车某商品的数量加减
	 */
	@Transactional
	public void updateCart(Cart cart){
		carts.updateByPrimaryKeySelective(cart);
	}
	
	/*
	 * 得到用户购物车信息
	 */	
	public List<Map> getCart(int userid){
		return cartw.getCart(userid);
	}
	
	/*
	 * 将商品加入购物车
	 */
	@Transactional
	public void insertCart(Cart cart){
		CartExample example=new CartExample();
		example.createCriteria().andGdidEqualTo(cart.getGdid()).andGsidEqualTo(cart.getGsid());
		long a=carts.countByExample(example);
		if(a==0){
			carts.insert(cart);
		}else{
			Cart example1=carts.selectByExample(example).get(0);
			example1.setGdcount(cart.getGdcount()+example1.getGdcount());
			carts.updateByPrimaryKey(example1);
		}
		
	}
	
	/*
	 * 用户登录
	 */
	public User login(String logname,String password) throws NotFoundLognameException,PasswordErrorException,UserStatusException{
		UserExample example=new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		List<User> list=user.selectByExample(example);
		if(list.size()==0||list==null){
			throw new NotFoundLognameException();
		}
		User user=list.get(0);
		if(!user.getPassword().equals(new Md5Hash(password, user.getSalt()).toString())){
			throw new PasswordErrorException();
		};
		if(user.getStatus()!=1){
			throw new UserStatusException();
		};
		return user;
	}
	
	/*
	 * 登录验证
	 */
	public boolean selectOfUserByUsername(String value){
		UserExample example=new UserExample();
		example.createCriteria().andLognameEqualTo(value);	
		return user.countByExample(example)==1;
	}
	
	/*
	 * 用户注册
	 */
	@Transactional
	public boolean insertOfUser(User users){
		
		String source=users.getPassword();
		String salt=UUID.randomUUID().toString();
		users.setPassword(new Md5Hash(source, salt).toString());
		users.setSalt(salt);
		users.setStatus(1);
		users.setUtid(1);
		
		return user.insert(users)==1;
	}
	
	/*
	 * 得到商品尺码
	 */
	public List<Goodssize> getGoodsSizeForAjax(){
		GoodssizeExample example=new GoodssizeExample();
		return goodssize.selectByExample(example);
	}
	
	/*
	 * 通过商品ID查商品信息
	 */		
	public Map getGoodsInfoByGdid(int gdid){
		return goodsimage.getGoodsInfoByGdid(gdid);
	}
	
	/*
	 * 关键字查询
	 */		
	public List<Goodsinfo> getAllGoodsInfoesForAjax(String keywords){
		GoodsinfoExample example=new GoodsinfoExample();
		example.createCriteria().andGdnameLike(keywords);
		int limit=10;
		int offset=(1-1)*limit;		
		RowBounds rowBounds=new RowBounds(offset, limit);
		return goodsinfo.selectByExampleWithRowbounds(example, rowBounds);
	}
	
}
