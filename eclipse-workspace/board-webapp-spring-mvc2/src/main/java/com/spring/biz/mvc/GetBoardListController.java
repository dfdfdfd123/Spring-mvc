package com.spring.biz.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;





public class GetBoardListController implements Controller {
	
	@Autowired
	BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1.  get request parameters
		
				// 2. process business logic
				List<BoardVO> boardList = boardService.listBoard();

				// 3.  
				ModelAndView mv = new ModelAndView();
				mv.addObject("boardList", boardList);		
				mv.setViewName("getBoardList");
				return mv;
	}

}
