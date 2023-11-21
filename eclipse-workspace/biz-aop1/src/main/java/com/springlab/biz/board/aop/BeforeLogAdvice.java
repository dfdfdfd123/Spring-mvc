package com.springlab.biz.board.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("[���� ó��] %s() ���� �� �Ű����� ��ó��...\n", method.getName());
		
	}
	


}
