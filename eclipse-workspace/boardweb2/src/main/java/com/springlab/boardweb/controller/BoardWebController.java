package com.springlab.boardweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardVO;
import com.springlab.biz.board.impl.BoardDAOImpl;
import com.springlab.biz.user.UserDAO;
import com.springlab.biz.user.UserVO;
import com.springlab.biz.user.impl.UserDAOImpl;

/**
 * Servlet implementation class BoardWebController
 */
//@WebServlet("/s/*")
public class BoardWebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
				
		// step #2. data processing
		HttpSession session = request.getSession();
		
		String urlPath = request.getPathInfo();
//		System.out.println(">>> " + urlPath);
		String viewName = null;
		
		if (urlPath.equals("/login")) {
			viewName = "/login.jsp";
		}
		else if (urlPath.equals("/login_proc")) {
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			UserDAO userDAO = new UserDAOImpl();
			UserVO user = userDAO.getUser(vo);
			
			// 3. 화면 네비게이션
			if (user != null) {
				viewName = "get_board_list";
			} else {
				viewName = "/login.jsp";
			}
		}
		else if (urlPath.equals("/logout")) {
			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
			session.invalidate();

			// 2. 세션 종료 후, 메인 화면으로 이동한다.
			viewName = "/login.jsp";
		}
		else if (urlPath.equals("/get_board_list")) {
			// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
			
			// 2. DB 연동 처리
			BoardDAO boardDAO = new BoardDAOImpl();
			List<BoardVO> boardList = boardDAO.listBoard();

			// 3. 응답 화면 구성
			request.setAttribute("boardList", boardList);
			
			viewName = "/getBoardList.jsp";
		}
		else if (urlPath.equals("/get_board")) {
			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAOImpl();
			BoardVO board = boardDAO.getBoard(vo);

			// 3. 응답 화면 구성
			request.setAttribute("board", board);
			
			viewName = "/getBoard.jsp";
		}
		else if (urlPath.equals("/insert_board")) {
			viewName = "/insertBoard.jsp";
		}
		else if (urlPath.equals("/insert_board_proc")) {
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			BoardDAO boardDAO = new BoardDAOImpl();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션
			viewName = "get_board_list";
		}
		else if (urlPath.equals("/update_board")) {
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAOImpl();
			boardDAO.updateBoard(vo);

			// 3. 화면 네비게이션
			viewName = "get_board_list";
		}
		else if (urlPath.equals("/delete_board")) {
			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAOImpl();
			boardDAO.deleteBoard(vo);

			// 3. 화면 네비게이션
			viewName = "get_board_list";
		}
		
		// step #3. output results
		if (viewName == null) {
			viewName = "/login.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
