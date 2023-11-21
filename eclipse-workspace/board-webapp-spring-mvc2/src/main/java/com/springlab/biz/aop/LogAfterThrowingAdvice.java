package com.springlab.biz.aop;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {

	public void afterThrowing(IllegalArgumentException ex) throws Throwable {
		System.out.println("--- after-throwing advice: " + ex.getMessage());		
	}
	
}
