package com.qingao.mgj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.qingao.mgj.pojo.Admin;
import com.qingao.mgj.pojo.GoodscollectionKey;
import com.qingao.mgj.pojo.User;

import com.qingao.mgj.exception.NotFoundLognameException;
import com.qingao.mgj.exception.PasswordErrorException;
import com.qingao.mgj.exception.UserStatusException;
import com.qingao.mgj.pojo.Cart;
import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.Orderlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qingao.mgj.service.Mgj_Service;

@RestController
@RequestMapping("/mgj")
public class Mgj_Controller {

	@Autowired
	Mgj_Service service;
	
	/*
	 * 查询该user是否已收藏该商品，若未收藏则收藏，若已收藏则取消收藏
	 */	
	@RequestMapping("insertcollection")
	public void insertcollection(HttpSession session,int gdid){
		User user=(User)session.getAttribute("user");
		int userid=user.getUserid();
		service.goodscollection(gdid, userid);
	}
 
	/*
	 * 查询user收藏过哪些商品，返回GoodscollectionKey类型集合
	 */
	@RequestMapping("changecolor")
	public List<GoodscollectionKey> changecolor(HttpSession session){
		User user=(User)session.getAttribute("user");
		int userid=user.getUserid();
		return service.changecolor(userid);
	}
	
	/*
	 * 客户订单管理，商户登陆后有订单就处理，没有不弹出（点击发货），通过商户登录实现.
	 */
	@RequestMapping("delivergoods")
	public Map DeliverGoods(HttpSession session){
		Admin ad=(Admin) session.getAttribute("Admin");
		if(ad==null){
			return null;
		}else{		
			Map map=new HashMap();
			map.put("Admin", ad);
			map.put("information", service.DeliverGoods(ad.getStid()));
			return map;
		}
	}
	
	/*
	 * 点击发货，删除待发货商品。
	 */
	@RequestMapping("deletedelivergoods")
	public void DeleteDeliverGoods(String olid,String ofid){

		service.DeleteDeliverGoods(olid,ofid);

	}
	/*
	 * 商品图片瀑布流
	 */
	@RequestMapping("getimage")
	public Object getimage(int pagenum){
		Map a=new HashMap();
		a.put("images", service.getAllGoodsimageForAjax(pagenum));
		a.put("pagenum1", pagenum);
		a.put("count", service.getGoodsinfoesCount());
		return a;
	}
	
	/*
	 * 显示商品被收藏次数
	 */
	@RequestMapping("getcollectionforajax")
	public List<Map> getcollectionforajax(int pagenum){
		return service.getcollectionforajax(pagenum);
	}
	
	/*
	 * 通过用户ID查询订单信息
	 */	
	@RequestMapping("selectorderinfobyuserid")
	public List<Orderinfo> selectOrderinfobyuserid(HttpSession session){
		User jj=(User)session.getAttribute("user");
		return service.selectOrderinfobyuserid(jj.getUserid());
	}
	
	/*
	 * 付款界面信息
	 */	
	@RequestMapping("selectorderlist")
	public List<Orderlist> selectorderlist(String ofid){
		
		return service.selectOrderListByOfid(ofid);
	}

	/*
	 * 生成订单信息
	 */
	@RequestMapping("insertorder") 
	public boolean insertOrdert(HttpSession session,String address,String contactnumber,String recipient,@RequestParam("ctid") List<Integer> ctid){
		User user=(User) session.getAttribute("user");
		service.insertOrder(user.getUserid(), address, contactnumber, recipient, ctid);
		return true;
	}
	
	/*
	 * 清除用户购物车里的某一个商品
	 */	
	@RequestMapping("deletecart")
	public boolean deleteCart(int ctid){
		service.deleteCart(ctid);
		return true;
	}

	/*
	 * 购物车某商品的数量加减
	 */
	@RequestMapping("changecartcount")
	public boolean changecartcount(Cart cart){
		service.updateCart(cart);
		return true;
	}
	
	/*
	 * 得到用户购物车信息
	 */
	@RequestMapping("getcart")
	public List<Map> getcart(HttpSession session){
		User user=(User) session.getAttribute("user");
		return service.getCart(user.getUserid());
	}

	/*
	 * 将商品加入购物车
	 */
	@RequestMapping("insertcart")
	public Object insertcart(Cart cart,HttpSession session){
		User user=(User) session.getAttribute("user");
		cart.setUserid(user.getUserid());
		service.insertCart(cart);
		return true;
	}
	
	/*
	 * 退出登录
	 */	
	@RequestMapping("removesession")
	public Object removesession(HttpSession session){
		session.removeAttribute("user");
		return null;
	}

	/*
	 * 登录得到session
	 */	
	@RequestMapping("getsession")
	public Object getsession(HttpSession session){
		
		return session.getAttribute("user");
	}
	
	/*
	 * 用户登录
	 */	
	@RequestMapping("login")
	public Object login(String logname,String password,HttpSession session){
		User user;
		try {
			user = service.login(logname, password);
			session.setAttribute("user",user);
			return 0;
		} catch (NotFoundLognameException e) {
			return 1;
		} catch (PasswordErrorException e) {
			return 2;
		} catch (UserStatusException e) {
			return 3;
		}		
	}

	/*
	 * 登录验证
	 */
	@RequestMapping("check")
	public boolean check(String value){
		
		return service.selectOfUserByUsername(value);
	}

	/*
	 * 验证码验证
	 */
	@RequestMapping("kaptch")
	public boolean kaptch(String jj,HttpSession session){
		String kaptch=(String) session.getAttribute("keycode");	
		return jj.equals(kaptch);
	}

	/*
	 * 用户注册
	 */
	@RequestMapping("insertofuser")
	public boolean insertofuser(User users){
		return service.insertOfUser(users);
	}
	
	/*
	 * 得到商品尺码
	 */	
	@RequestMapping("getgoodssizeforajax")
	public Object getGoodsSizeForAjax(){
		return service.getGoodsSizeForAjax();
	}
	
	/*
	 * 通过商品ID查商品信息
	 */	
	@RequestMapping("getgoodsinfobygdid")
	public Object getGoodsInfoByGdid(int gdid){
		return service.getGoodsInfoByGdid(gdid);
	}

	/*
	 * 关键字查询
	 */	
	@RequestMapping("getgoodsinfogdname")
	public Object getgoodsinfogdname(String keywords){
		return service.getAllGoodsInfoesForAjax("%"+keywords+"%");
	}
	
}
