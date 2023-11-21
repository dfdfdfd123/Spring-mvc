<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.biz.user.*" %>    

<%
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	UserDO vo = new UserDO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserService userService = new UserServiceImpl();
	UserDO user = userService.getUser(vo);
	if (user != null && !user.getPassword().equals(password)) {
		user = null;
	}
	
	// 3. 화면 네비게이션
	if (user != null) {
		response.sendRedirect("getBoardList.jsp");
	}
	else {
		response.sendRedirect("login.jsp");
	}
%>
