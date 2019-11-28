package com.qingao.mgj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SystemTool_1 {

	@Autowired
	AppService appService;

	/*@Scheduled(fixedRate=5000)*/
	public void sayHi(){
		System.out.println("你好");
	}

	/*@Scheduled(fixedRate=10000)*/
	public void eat(){
		
		System.out.println("你好================");
	}
	
	
}
