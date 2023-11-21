package com.example.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.biz.board.BoardDO;
import com.example.biz.board.BoardService;

public class GetBoardController implements Controller {

	@Autowired
 	BoardService boardService;

 	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");

	 	BoardDO vo = new BoardDO();
	 	vo.setSeq(Integer.parseInt(seq));
		
	 	BoardDO board = boardService.getBoard(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("getBoard");
		
		return mv;				
	}

}
