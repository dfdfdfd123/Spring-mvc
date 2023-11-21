package com.example.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.biz.board.BoardDO;
import com.example.biz.board.BoardService;

public class GetBoardListController implements Controller {

	@Autowired
	@Qualifier("boardService")
 	BoardService boardService;

 	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardDO> boardList = boardService.listBoard();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board_list", boardList);
		mv.setViewName("getBoardList");
		
		return mv;				
	}

}
