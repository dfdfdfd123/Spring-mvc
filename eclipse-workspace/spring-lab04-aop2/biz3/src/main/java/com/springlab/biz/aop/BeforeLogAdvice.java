package com.springlab.biz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeLogAdvice {

	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
				
		System.out.print("[사전 처리] " + method + "() 메소드");
		System.out.println(args.length > 0 ? " ARGS 정보: " + args[0].toString() : "");
	}
}
