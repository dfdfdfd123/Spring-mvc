<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.biz.board.*"%>
<%    
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	
	// 2. DB 연동 처리
	BoardDO vo = new BoardDO();
	vo.setSeq(Integer.parseInt(seq));
	
 	BoardService boardService = new BoardServiceImpl();
 	boardService.deleteBoard(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
 %>