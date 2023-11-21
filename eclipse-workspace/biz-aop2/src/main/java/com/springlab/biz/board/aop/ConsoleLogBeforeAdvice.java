package com.springlab.biz.board.aop;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("logBeforeAdvice")
public class ConsoleLogBeforeAdvice {
	
	@Pointcut("execution(* com.springlab.biz.board..*Impl.*(..))")
	void allPointcut()
	{
		
	}

	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("[荤傈 贸府] 荤傈 贸府...");
	}
}
