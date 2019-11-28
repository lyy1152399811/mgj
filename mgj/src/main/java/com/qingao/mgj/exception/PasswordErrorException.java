package com.qingao.mgj.exception;

public class PasswordErrorException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("用户名密码有误");
	}
	
}
