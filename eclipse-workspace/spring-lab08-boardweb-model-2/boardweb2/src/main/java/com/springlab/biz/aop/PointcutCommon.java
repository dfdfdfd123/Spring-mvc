package com.springlab.biz.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.springlab.biz..BoardServiceImpl.*(..))")
	public void allPointcut() {}

	@Pointcut("execution(* com.springlab.biz..BoardServiceImpl.get*(..))")
	public void getPointcut() {}
	
}
