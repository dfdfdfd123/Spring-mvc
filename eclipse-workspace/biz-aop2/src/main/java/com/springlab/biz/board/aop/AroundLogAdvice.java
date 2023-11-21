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
		System.out.printf("[전후 처리] %s() 메소드 실행 시간 : %d msec\n", 
				invocation.getMethod().getName(),
				stopwatch.getTotalTimeMillis());
		
		
		return null;
	}

}
