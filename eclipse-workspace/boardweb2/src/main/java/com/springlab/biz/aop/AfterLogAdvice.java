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

		System.out.print("[���� ó��] " + method + "() �޼ҵ�");
		System.out.println(returnObj != null ? "��ȯ��: " + returnObj.toString() : "");
	}

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exObj")
	public void afterThrowingLog(JoinPoint jp, Exception exObj) {
		String method = jp.getSignature().getName();

		System.out.println("[���� ó��] " + method + "() �޼ҵ� ���� �� ���� �߻� : " + exObj.getMessage());
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog() {
		System.out.println("[���� ó��2] ����Ͻ� ���� ���� �� ������ ����...");
	}
	
}
