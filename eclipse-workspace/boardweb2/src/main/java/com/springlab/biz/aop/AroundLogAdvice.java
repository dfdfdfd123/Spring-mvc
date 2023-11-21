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
		
		System.out.println("[���� ó��3] Around advice ����...");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println("[���� ó��3] " + method + "() �޼ҵ� ���� �ð� : " + stopWatch.getTotalTimeMillis() + " msec");
	
		return obj;
	}
}
