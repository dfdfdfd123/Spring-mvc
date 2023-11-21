package com.springlab.biz.board.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("[사전 처리] %s() 실행 전 매개변수 전처리...\n", method.getName());
		
	}
	


}
