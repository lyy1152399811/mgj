package com.qingao.mgj.service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import com.qingao.mgj.AlipayConfig;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.Orderlist;

@Service
public class AppService_Ali {

	@Autowired
	private Mgj_Service appservice;
	
	public void ali(HttpServletResponse response,String ofid) throws AlipayApiException, IOException{
		List<Orderlist> order=appservice.selectOrderListByOfid(ofid);
		int a=0;
		for(int i=0;i<order.size();i++){
			a+=(order.get(i).getGdcount()*order.get(i).getPrice());
		}
		//设置编码  
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter();   
		//获得初始化的AlipayClient 
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);   
		//设置请求参数
		AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();   aliPayRequest.setReturnUrl(AlipayConfig.return_url);   aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);      
		//商户订单号，后台可以写一个工具类生成一个订单号，必填  
		String order_number = new String(order.get(0).getOfid());  
		//付款金额，从前台获取，必填 
		String total_amount = new String(""+a+"");  
		//订单名称，必填  
		String subject = new String(order.get(0).getOfid());
		aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","    + "\"total_amount\":\"" + total_amount + "\","    + "\"subject\":\"" + subject + "\","    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");  
		//请求   
		String result = alipayClient.pageExecute(aliPayRequest).getBody();   
		//输出   
		out.println(result);//以下写自己的订单代码 } 
	}

	
}