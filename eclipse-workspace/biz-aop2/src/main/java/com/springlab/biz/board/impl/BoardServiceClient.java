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
		vo.setTitle("�׽�Ʈ ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("�׽�Ʈ �Խ��� ���Դϴ�....");
		boardService.insertBoard(vo);
		
		
		
		vo.setSeq(1);
		vo = boardService.getBoard(vo);
		vo.setCnt(vo.getCnt()+1);
		boardService.updateBoard(vo);

		vo.setSeq(vo.getCnt());
		boardService.deleteBoard(vo);
		
//		for (BoardVO board : boardList) {
		//		System.out.println("�Խñ�: " + board.toString());
		//	}
			
			// vo.setTitle("������ �����Դϴ�");
			// boardList = boardService.listBoard();
		
		
		List<BoardDO> boardList = boardService.listBoard();
		for (BoardDO board : boardList) {
			System.out.printf("%d: %s\n", board.getSeq(), board.toString());
			
			
					
		}
		
		context.close();
		
	//	for (BoardVO board : boardList) {
	//		System.out.println("�Խñ�: " + board.toString());
	//	}
			
		
	}

}
