package com.example.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.biz.board.BoardDO;
import com.example.biz.board.BoardService;
import com.example.biz.user.UserDO;
import com.example.biz.user.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes({"user_name", "board", "menu_list"})
public class BoardController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("boardService")
 	private BoardService boardService;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
//	public ModelAndView login() {
//		return new ModelAndView("login");
//	}
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="login_proc.do")
//	public String authenticate_login(HttpServletRequest request) {
//	public String authenticate_login(@RequestParam("id")String id, @RequestParam("password")String password) {
	public String authenticate_login(@RequestParam String id, @RequestParam String password, Model model) {
		// 1. 사용자 입력 정보 추출
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserDO vo = new UserDO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDO user = userService.getUser(vo);
		if (!user.getPassword().equals(password)) {
			user = null;
		}
		else {
			model.addAttribute("user_name", user.getName());
		}
		
		// 3. 화면 네비게이션
		String viewName = null;
		if (user != null) {
			viewName = "redirect:get_board_list.do";
		}
		else {
			viewName = "redirect:login.do";
		}
		
		return viewName;
	}
	
	@RequestMapping("logout_proc.do")
	public String logout(HttpSession session) {
		// 1. 세션 종료
		if (session != null) {
			session.invalidate();
		}
		
		// 2. 화면 네비게이션 - goto main view
		return "redirect:login.do";
	}
	
	@GetMapping("get_board_list.do")
	public ModelAndView getBoardList() {
		List<BoardDO> boardList = boardService.listBoard();
		
		Map<String, String> menuList = new HashMap<String, String>();
		menuList.put("제목", "TITLE");
		menuList.put("내용", "CONTENT");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board_list", boardList);
		mv.addObject("menu_list", menuList);
		mv.setViewName("getBoardList");
		
		return mv;				
	}
		
	@RequestMapping("get_board.do")
	public String getBoard(@RequestParam String seq, Model model) {
	 	BoardDO vo = new BoardDO();
	 	vo.setSeq(Integer.parseInt(seq));
		
	 	BoardDO board = boardService.getBoard(vo);		
		model.addAttribute("board", board);
	 	
	 	vo = boardService.getBoard(vo);
	 	if (vo != null) {
		 	board.setSeq(vo.getSeq());
		 	board.setTitle(vo.getTitle());
		 	board.setWriter(vo.getWriter());
		 	board.setContent(vo.getContent());
		 	board.setRegDate(vo.getRegDate());
		 	board.setCnt(vo.getCnt());
	 	}
	 	
		return "getBoard";				
	}

	@RequestMapping("insert.do")
	public String displayInsertForm() {
		return "insertBoard";
	}
	
//	@RequestMapping(value="insert_board.do", method=RequestMethod.POST)
//	public String insertBoard(
//		@RequestParam String title, 
//		@RequestParam String writer, 
//		@RequestParam String content)  {
//		
//		BoardDO vo = new BoardDO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		
//	 	boardService.insertBoard(vo);
//		
//		return "redirect:get_board_list.do";				
//	}
	@PostMapping("insert_board.do")
	public String insertBoard(BoardDO vo)  {
				
	 	boardService.insertBoard(vo);
		
		return "redirect:get_board_list.do";				
	}
	
	@PostMapping("update_board.do")
	public String updateBoard(@ModelAttribute("board") BoardDO vo)  {
				
	 	boardService.updateBoard(vo);
		
		return "redirect:get_board_list.do";				
	}
	
	@GetMapping("delete_board.do")
	public String deleteBoard(BoardDO vo) {

		boardService.deleteBoard(vo);
		
		return "redirect:get_board_list.do";				
	}
}
