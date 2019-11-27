package com.qingao.mgj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.qingao.mgj.pojo.Admin;
import com.qingao.mgj.pojo.GoodscollectionKey;
import com.qingao.mgj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * 查询某商品被的收藏次数
	 */
	@RequestMapping("getcollectioncount")
	public long getcollectioncount(int gdid){
		return service.goodscollectioncount(gdid); 
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
	public List<Map> DeliverGoods(HttpSession session){

		Admin ad=(Admin) session.getAttribute("Admin");
		return service.DeliverGoods(ad.getStid()); 

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
}
