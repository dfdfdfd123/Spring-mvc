package com.springlab.biz.board.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AfterThrowingLogAdvice implements ThrowsAdvice {

	
	public void afterThrowing(IllegalArgumentException ex) throws Throwable {
		System.out.printf("[예외 처리] %s() 예외 발생 - %s\n", ex.getMessage());
		
	}

}
