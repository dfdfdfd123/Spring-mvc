package com.spring.biz.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;
import com.springlab.biz.user.UserService;
import com.springlab.biz.user.UserVO;

@Controller
@RequestMapping("/")
@SessionAttributes({"user_name"})
public class BoardController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("login")
	public String login()
	{
		return "login";
	}
	
	// @RequestMapping(value="/login_proc", method=RequestMethod.POST)
	@PostMapping("login_proc")
	// public String logicProc(@RequestParam("id") String id, @RequestParam("password") String password)
	// public String logicProc(@RequestParam String id, @RequestParam String password)
	public String logicProc(UserVO vo, Model model)
	
	{
		UserVO user = userService.getUser(vo);
		
		String userName = null;
		String viewName = null;
		// if (user != null && password.equals(user.getPassword())) 
		if (user != null && vo.getPassword().equals(user.getPassword())) 
		{
			viewName = "redirect:get_board_list";
			userName = user.getName();
		} else {
			viewName = "login";
		}
		
		model.addAttribute("user_name", userName);
		return viewName;
	}
	
	@RequestMapping("logout_prec")
	public String logout(HttpSession session)
	{
		session.invalidate();
		
		return "login";
		
	}
	
	@RequestMapping("get_board_list")
	public String getBoardList(Model model)
	{
		List<BoardVO> boardList = boardService.listBoard();
		
		model.addAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
