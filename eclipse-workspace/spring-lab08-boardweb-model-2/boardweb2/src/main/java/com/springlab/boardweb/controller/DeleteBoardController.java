package com.springlab.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

public class DeleteBoardController implements MyController {

	@Autowired
	private BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq");

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		boardService.deleteBoard(vo);
				
		// 3. 화면 네비게이션
		return "redirect:get_board_list";
	}

}
