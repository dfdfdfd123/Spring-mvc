package com.springlab.biz.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.impl.BoardServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.springlab.biz.board", "com.springlab.biz.user", "com.springlab.biz.aop"})
@EnableAspectJAutoProxy
public class AppContextConfig {
	
	@Autowired
	private BoardService boardService;
	
	@Bean
	public BoardService boardServiceProxy() {
		return (BoardService) Proxy.newProxyInstance(
				BoardServiceImpl.class.getClassLoader(), 
				new Class[] { BoardService.class }, 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long start = System.currentTimeMillis();
						
						Object result = method.invoke(boardService, args);
						
						long end = System.currentTimeMillis();
						System.out.println(method.getName() + "() : " + (end - start) + " msec");		

						return result;
					}
				});
	}
}
