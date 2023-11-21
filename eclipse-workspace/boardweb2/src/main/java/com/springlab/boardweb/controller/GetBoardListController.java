package com.springlab.boardweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

public class GetBoardListController implements MyController {

	@Autowired
	private BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
		
		// 2. DB ���� ó��
		List<BoardVO> boardList = boardService.listBoard();

		// 3. ���� ȭ�� ����
		request.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
