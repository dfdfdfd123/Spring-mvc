package com.example.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.biz.board.BoardDO;
import com.example.biz.board.BoardService;

public class InsertBoardController implements Controller {

	@Autowired
 	BoardService boardService;

 	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDO vo = new BoardDO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
	 	boardService.insertBoard(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:get_board_list.do");
		
		return mv;				
	}

}
