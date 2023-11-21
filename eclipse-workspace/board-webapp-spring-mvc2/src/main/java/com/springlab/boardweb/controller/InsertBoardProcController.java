package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

public class InsertBoardProcController implements MyController {

	@Autowired
	private BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է� ���� ����
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		boardService.insertBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "redirect:get_board_list";
	}

}
