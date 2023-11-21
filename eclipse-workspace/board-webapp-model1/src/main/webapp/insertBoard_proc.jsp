<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.biz.board.*"%>
<%    
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
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
	response.sendRedirect("getBoardList.jsp");
 %>