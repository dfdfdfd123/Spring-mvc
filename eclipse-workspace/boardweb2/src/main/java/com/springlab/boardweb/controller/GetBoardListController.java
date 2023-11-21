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
		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		
		// 2. DB 연동 처리
		List<BoardVO> boardList = boardService.listBoard();

		// 3. 응답 화면 구성
		request.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
