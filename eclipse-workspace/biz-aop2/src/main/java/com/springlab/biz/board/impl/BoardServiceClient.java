package com.springlab.biz.board.impl;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardDO;

public class BoardServiceClient {

	public static void main(String[] args) {

//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
//					com.springlab.biz.common.AppContextConfig.class);
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springlab/biz/common/AppContextConfig.xml");
		
		
		
		BoardService boardService = (BoardService) context.getBean("boardService");
		
		BoardDO vo = new BoardDO();
		vo.setTitle("테스트 제목");
		vo.setWriter("홍길동");
		vo.setContent("테스트 게시판 글입니다....");
		boardService.insertBoard(vo);
		
		
		
		vo.setSeq(1);
		vo = boardService.getBoard(vo);
		vo.setCnt(vo.getCnt()+1);
		boardService.updateBoard(vo);

		vo.setSeq(vo.getCnt());
		boardService.deleteBoard(vo);
		
//		for (BoardVO board : boardList) {
		//		System.out.println("게시글: " + board.toString());
		//	}
			
			// vo.setTitle("수정된 제목입니다");
			// boardList = boardService.listBoard();
		
		
		List<BoardDO> boardList = boardService.listBoard();
		for (BoardDO board : boardList) {
			System.out.printf("%d: %s\n", board.getSeq(), board.toString());
			
			
					
		}
		
		context.close();
		
	//	for (BoardVO board : boardList) {
	//		System.out.println("게시글: " + board.toString());
	//	}
			
		
	}

}
