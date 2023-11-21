package com.example.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.biz.board.BoardDO;
import com.example.biz.board.BoardService;
import com.example.biz.board.BoardServiceImpl;

public class UpdateBoardController implements Controller {

	@Autowired
 	BoardService boardService;

 	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		BoardDO vo = new BoardDO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setContent(content);
				
	 	boardService.updateBoard(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:get_board_list.do");
		
		return mv;				
	}

}
