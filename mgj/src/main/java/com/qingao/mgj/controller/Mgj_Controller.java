package com.qingao.mgj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.qingao.mgj.pojo.GoodscollectionKey;
import com.qingao.mgj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingao.mgj.service.Mgj_Service;

@Controller
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
	
}
