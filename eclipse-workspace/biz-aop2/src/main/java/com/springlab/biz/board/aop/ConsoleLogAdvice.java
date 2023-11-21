package com.springlab.biz.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service("consoleLogAdvice")
public class ConsoleLogAdvice {
	
	@Pointcut("execution(* com.springlab.biz.board..*Impl.*(..))")
	void allPointcut()
	{
		
	}
	
	@Pointcut("execution(* com.springlab.biz.board..*Impl.*(..))")
	void getPointcut()
	{
		
	}
	
	@AfterReturning(pointcut="getPointcut()", returning="returnObj")
	public void afterReturningLog(JoinPoint jp, Object returnObj)
		{
			System.out.printf("[���� ó��] %s() �޼ҵ� ��ȯ��: %s\n", 
					jp.getSignature().getName(),returnObj == null ? "null" : returnObj.toString());
			
		}
	
	@AfterThrowing(pointcut="allPointcut", throwing="ex")
	public void afterThrowingLog(JoinPoint jp, Exception ex)
	{
		System.out.printf("[���� ó��] $s() �޼ҵ� ���� �߻�: %s\n",
				jp.getSignature().getName(), ex.getMessage());
	}
	
	@After("allPointcut()")
	public void afterLog(JoinPoint jp)
	{
		System.out.printf("[���� ó��] %s() �޼ҵ� ���� ���� ó��...\n",
				jp.getSignature().getName());
				
	}
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable
	{
		StopWatch stopwatch = new StopWatch();
		
		stopwatch.start();
		
		Object result = pjp.proceed();
		
		stopwatch.stop();
		
		System.out.printf("[���� ó��] %s() �޼ҵ� ���� �ð�: %d msec\n",
				pjp.getSignature().getName(),
				stopwatch.getTotalTimeMillis());
		
		return result;
	}



}
