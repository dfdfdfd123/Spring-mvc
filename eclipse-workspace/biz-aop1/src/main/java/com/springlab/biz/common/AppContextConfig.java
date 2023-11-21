package com.springlab.biz.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.impl.BoardServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.springlab.biz.board", "com.springlab.biz.user"})
public class AppContextConfig {
	
}
