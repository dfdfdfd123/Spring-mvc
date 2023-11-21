package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;
import com.springlab.biz.board.impl.BoardDAOImpl;

public class UpdateBoardController implements MyController {

	@Autowired
	private BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է� ���� ����
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		boardService.updateBoard(vo);		
		// 3. ȭ�� �׺���̼�
		return "redirect:get_board_list";
	}

}
