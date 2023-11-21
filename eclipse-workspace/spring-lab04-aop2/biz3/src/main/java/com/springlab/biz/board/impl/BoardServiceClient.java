package com.springlab.biz.board.impl;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
					com.springlab.biz.common.AppContextConfig.class);
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
//				"com/springlab/biz/common/AppContextConfig.xml");
		
		BoardService boardService = (BoardService) context.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 제목");
		vo.setWriter("홍길동");
		vo.setContent("테스트 게시판 글입니다....");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.listBoard();
		for (BoardVO board : boardList) {
			System.out.println("게시글: " + board.toString());
		}
		
		vo.setSeq(3);
		vo = boardService.getBoard(vo);
		int cnt = vo.getCnt();
		vo.setCnt(cnt+1);
		boardService.updateBoard(vo);

		vo.setSeq(2);
		boardService.deleteBoard(vo);
		
		boardList = boardService.listBoard();
		for (BoardVO board : boardList) {
			System.out.println("게시글: " + board.toString());
		}
			
		context.close();
	}

}
