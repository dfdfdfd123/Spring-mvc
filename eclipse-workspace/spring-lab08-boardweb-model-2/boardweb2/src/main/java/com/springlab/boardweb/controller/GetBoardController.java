package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

public class GetBoardController implements MyController {

	@Autowired
	private BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardVO board = boardService.getBoard(vo);

		// 3. ���� ȭ�� ����
		request.setAttribute("board", board);
		
		return "getBoard";
	}

}
