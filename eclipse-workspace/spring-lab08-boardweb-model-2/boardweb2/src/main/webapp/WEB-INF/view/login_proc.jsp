<%@page import="com.springlab.biz.user.impl.UserDAOImpl"%>
<%@page import="com.springlab.biz.user.UserDAO"%>
<%@page import="com.springlab.biz.user.UserVO"%>
<%@page contentType="text/html; charset=UTF-8"%>

<%
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
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>