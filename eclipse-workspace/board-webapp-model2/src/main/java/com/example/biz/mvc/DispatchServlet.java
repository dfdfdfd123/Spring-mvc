package com.example.biz.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.biz.board.BoardDO;
import com.example.biz.board.BoardService;
import com.example.biz.board.BoardServiceImpl;
import com.example.biz.user.UserDO;
import com.example.biz.user.UserService;
import com.example.biz.user.UserServiceImpl;

/**
 * Servlet implementation class DispatchServlet
 */
// @WebServlet("/*")
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String contextPath = getServletContext().getContextPath();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		System.out.printf("Context Path = %s, Path = %s \n", contextPath, path);
		
		// step #2. process business logic
		String viewName = null;
		
		if (path.equals("/login.do"))
		{
			 viewName ="login.jsp";
		}
		else if (path.equals("login_proc.do"))
		{
			HttpSession session = request.getSession(false);
			if (session != null)
			{
				session.invalidate();
			}
			
			// 2. 화면 네비게이션
			viewName = "redirect:login.do";
		}
		else if (path.equals("login_proc.do"))
		{
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// DB 연동 처리
			UserDO vo = new UserDO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserService userService = new UserServiceImpl();
			UserDO user = userService.getUser(vo);
			
			if (user != null && !user.getPassword().equals(password))
			{
				user = null;
			}
			
			// 화면 네비게이션 
			if (user != null)
			{
				viewName = "redirect:get_board_list_do";
			}
			else {
				viewName = "redirect:login.do";
			}
			
			 // viewName ="login.jsp";
		}
		 else if(path.equals("/login_proc.do"))
		 {
			
			// 1. 사용자 입력 추출
			// 2. DB 연동 처리
		 	BoardService boardService = new BoardServiceImpl();
			List<BoardDO> boardList = boardService.listBoard();
			
			// 3. 응답 화면 구성 및 출력
			request.setAttribute("board_list", boardList);
			
			viewName = "getBoardList.jsp";
		   
		}
		 else if (path.equals("/get_board.do"))
		 {
			// 1. 사용자 입력 추출
				String seq = request.getParameter("seq");

				// 2. DB 연동 처리
			 	BoardDO vo = new BoardDO();
			 	vo.setSeq(Integer.parseInt(seq));
				
			 	BoardService boardService = new BoardServiceImpl();
			 	BoardDO board = boardService.getBoard(vo);
				
				// 3. 응답 화면 구성 및 출력
			 	
			 	request.setAttribute("board", board);
			 	
			 	viewName = "getBoard.jsp";
		 }
		 else if (path.equals("/insert_board.do"))
		 {
			 viewName = "insertBoard.jsp";
		 }
		 else if (path.equals("/insert_board.do"))
		 {
			 viewName = "insertBoard.jsp";
		 }
		 else if (path.equals("/register_board.do"))
		 {
			 
			 // 사용자 입력 정보 추출
			 String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				// 2. DB 연동 처리
				BoardDO vo = new BoardDO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				
			 	BoardService boardService = new BoardServiceImpl();
			 	boardService.insertBoard(vo);
				
				// 3. 화면 네비게이션
				response.sendRedirect("redirect:get_board_list.do");
		 }
		 else if (path.equals("/update_board.do"))
		 {
			// 1. 사용자 입력 정보 추출
				request.setCharacterEncoding("UTF-8");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String seq = request.getParameter("seq");
				
				// 2. DB 연동 처리
				BoardDO vo = new BoardDO();
				vo.setSeq(Integer.parseInt(seq));
				vo.setTitle(title);
				vo.setContent(content);
				
			 	BoardService boardService = new BoardServiceImpl();
			 	boardService.updateBoard(vo);
				
				// 3. 화면 네비게이션
			 	viewName = "redirect:get_board_list.do";
				// response.sendRedirect("getBoardList.jsp");
		 }
		 else if (path.equals("/delete_board.do"))
		 {
			// 1. 사용자 입력 정보 추출
				
				String seq = request.getParameter("seq");
				
				// 2. DB 연동 처리
				BoardDO vo = new BoardDO();
				vo.setSeq(Integer.parseInt(seq));
				
			 	BoardService boardService = new BoardServiceImpl();
			 	boardService.deleteBoard(vo);
				
				// 3. 화면 네비게이션
				
			 viewName = "redirect:get_board_list.do";
		 }
		
		
		// step #3. output results to client
		
		if (viewName == null)
		{
			viewName = "login.jsp";
		}
		if (viewName.contains("redirect:"))
		{
			viewName = viewName.substring("redirect:".length()); // 왼쪽의 viewName 와 오른쪽의 viewName는 다름
			response.sendRedirect(viewName);
		}
		else 
		{
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
