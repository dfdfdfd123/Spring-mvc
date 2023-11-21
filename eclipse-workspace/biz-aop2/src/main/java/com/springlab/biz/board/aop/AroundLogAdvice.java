package com.springlab.biz.board.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class AroundLogAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object result = invocation.proceed();
		
		stopwatch.stop();
		System.out.printf("[���� ó��] %s() �޼ҵ� ���� �ð� : %d msec\n", 
				invocation.getMethod().getName(),
				stopwatch.getTotalTimeMillis());
		
		
		return null;
	}

}
