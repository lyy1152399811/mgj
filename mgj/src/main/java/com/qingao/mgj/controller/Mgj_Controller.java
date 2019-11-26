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
	
	@RequestMapping("insertcollection")
	public void insertcollection(HttpSession session,int gdid){
		User user=(User)session.getAttribute("user");
		int userid=user.getUserid();
		service.goodscollection(gdid, userid);
	}
 
	@RequestMapping("getcollectioncount")
	public long getcollectioncount(int gdid){
		return service.goodscollectioncount(gdid); 
	}
	 
	@RequestMapping("changecolor")
	public List<GoodscollectionKey> changecolor(HttpSession session){
		User user=(User)session.getAttribute("user");
		int userid=user.getUserid();
		return service.changecolor(userid);
	}
	
}
