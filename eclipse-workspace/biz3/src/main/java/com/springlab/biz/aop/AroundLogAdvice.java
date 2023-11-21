package com.springlab.biz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class AroundLogAdvice {

	@Around("PointcutCommon.getPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		System.out.println("[사전 처리3] Around advice 실행...");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println("[사후 처리3] " + method + "() 메소드 실행 시간 : " + stopWatch.getTotalTimeMillis() + " msec");
	
		return obj;
	}
}
