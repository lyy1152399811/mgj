package com.qingao.mgj.exception;

public class LogNameIsNotExistException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("用户名不存在");
	}
	
}
