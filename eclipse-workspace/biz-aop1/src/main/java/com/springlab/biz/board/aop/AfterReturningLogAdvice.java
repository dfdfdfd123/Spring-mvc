package com.springlab.biz.board.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterReturningLogAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("[사후 처리] %s() 실행 후 반환값 후처리...\n", method.getName());
		
	}

}
