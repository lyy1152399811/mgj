package com.qingao.mgj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;

import com.qingao.mgj.pojo.Orderlist;
import com.qingao.mgj.pojo.User;
import com.qingao.mgj.service.AppService;
import com.qingao.mgj.service.AppService_Ali;
import com.qingao.mgj.service.Mgj_Service;

@Controller
@RequestMapping("/ali")
public class PayController {

	@Autowired
	AppService_Ali appService_ali;
	
	
	@Autowired
	private Mgj_Service appService;
	
	
	@RequestMapping("pay")
	public void ali(HttpServletResponse response,String ofid) throws IOException, AlipayApiException {
		appService_ali.ali(response,ofid);
	}

	@RequestMapping("paydone")
	public String paydone(HttpServletRequest request,HttpSession session) {
		String ss=request.getParameter("out_trade_no");	
		appService.paydone11(ss);
		List<Orderlist> list=appService.selectOrderListByOfid(ss);
		User user1=(User)session.getAttribute("user");
		int c = user1.getUserid();
		for(int i=0;i<list.size();i++){
			int a=list.get(i).getGdid();
			int b=list.get(i).getGsid();
			appService.delectcart(a,b,c);
		}
		return "/paydone.html";
	}
}
