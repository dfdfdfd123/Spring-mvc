<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
	// 1. 세션 종료
	session.invalidate();
	
	// 2. 화면 네비게이션 - goto main view
	response.sendRedirect("login.jsp");
 %>