package com.springlab.jdbctest.board;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(
						com.springlab.jdbctest.common.AppContextConfig.class);
		
		BoardService service = (BoardService) context.getBean("boardService");
		
		BoardDO board = new BoardDO();
		board.setTitle("테스트 게시글");
		board.setWriter("홍길동");
		board.setContent("게시글 테스트입니다...");
		service.insertBoard(board);
		
		board.setSeq(1);
		board = service.getBoard(board);
		board.setCnt(board.getCnt()+1);
		service.updateBoard(board);
		
		board.setSeq(board.getCnt());
		service.deleteBoard(board);
		
		//List<BoardDO> list = service.listBoard();
	//	System.out.println("게시글 목록 : ");
		//for(BoardDO bd : list)
		//{
		//	System.out.printf("%d: %s", bd.getSeq(), bd.toString());
		//}
		//
	//	context.close();
		
		
	}

}
