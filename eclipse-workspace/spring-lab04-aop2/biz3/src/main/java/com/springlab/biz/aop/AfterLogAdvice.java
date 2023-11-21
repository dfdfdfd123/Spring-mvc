package com.springlab.biz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterLogAdvice {
	
//	@Pointcut("execution(* com.springlab.biz..BoardServiceImpl.*(..))")
//	public void allPointcut() {}
//
//	@Pointcut("execution(* com.springlab.biz..BoardServiceImpl.get*(..))")
//	public void getPointcut() {}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();

		System.out.print("[사후 처리] " + method + "() 메소드");
		System.out.println(returnObj != null ? "반환값: " + returnObj.toString() : "");
	}

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exObj")
	public void afterThrowingLog(JoinPoint jp, Exception exObj) {
		String method = jp.getSignature().getName();

		System.out.println("[예외 처리] " + method + "() 메소드 수행 중 예외 발생 : " + exObj.getMessage());
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog() {
		System.out.println("[사후 처리2] 비즈니스 로직 수행 후 무조건 실행...");
	}
	
}
