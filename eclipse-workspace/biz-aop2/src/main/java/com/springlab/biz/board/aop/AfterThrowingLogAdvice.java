package com.springlab.biz.board.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AfterThrowingLogAdvice implements ThrowsAdvice {

	
	public void afterThrowing(IllegalArgumentException ex) throws Throwable {
		System.out.printf("[���� ó��] %s() ���� �߻� - %s\n", ex.getMessage());
		
	}

}
