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
			System.out.printf("[사후 처리] %s() 메소드 반환값: %s\n", 
					jp.getSignature().getName(),returnObj == null ? "null" : returnObj.toString());
			
		}
	
	@AfterThrowing(pointcut="allPointcut", throwing="ex")
	public void afterThrowingLog(JoinPoint jp, Exception ex)
	{
		System.out.printf("[예외 처리] $s() 메소드 예외 발생: %s\n",
				jp.getSignature().getName(), ex.getMessage());
	}
	
	@After("allPointcut()")
	public void afterLog(JoinPoint jp)
	{
		System.out.printf("[사후 처리] %s() 메소드 최종 사후 처리...\n",
				jp.getSignature().getName());
				
	}
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable
	{
		StopWatch stopwatch = new StopWatch();
		
		stopwatch.start();
		
		Object result = pjp.proceed();
		
		stopwatch.stop();
		
		System.out.printf("[전후 처리] %s() 메소드 실행 시간: %d msec\n",
				pjp.getSignature().getName(),
				stopwatch.getTotalTimeMillis());
		
		return result;
	}



}
