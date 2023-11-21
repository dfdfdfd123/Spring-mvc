package com.spring.biz.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springlab.biz.user.UserService;
import com.springlab.biz.user.UserVO;
import com.springlab.boardweb.controller.MyController;

public class LoginProcController implements Controller {
	
	@Autowired
	private UserService userService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
	
		UserVO vo = new UserVO();
		vo.setId(id);
		UserVO user = userService.getUser(vo);
				
		ModelAndView mv = new ModelAndView();
		if (user != null && password.equals(user.getPassword())) {
			mv.setViewName("redirect:get_board_list");
		} else {
			return "login";
		}
		
		return mv;
	}

}

