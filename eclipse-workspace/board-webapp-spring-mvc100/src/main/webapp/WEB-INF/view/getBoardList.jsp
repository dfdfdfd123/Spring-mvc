<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ page import="com.example.biz.board.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
body {
	max-width: 800px;
	margin: 0 auto;
	text-align: center;
}
a {
    display: inline-block;
    background: lightblue;
    color: #FFF;
    border: 0;
    border-radius: 4px;
    text-align: center;
    padding: 3px 3px;
    line-height: 1;
   text-decoration: none;
}
a:hover {
  background: #DDD;
  color: #000;
}
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<h3>${user_name}님, 환영합니다...<a href="logout_proc.do">Log-out</a></h3>
	
	<!-- 검색 폼 -->
	<form action="get_board_list.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<c:forEach var="menu" items="${menu_list}">
						<option value="${menu.value}">${menu.key}</option>
						</c:forEach>				
					</select>
					<input type="text" name="searchKeyword" placeholder="검색어" />
					<input type="submit" value="검색" />
				</td>
			</tr>	
		</table>
	</form>
	
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="50">번호</th>
			<th bgcolor="orange" width="400">제목</th>
			<th bgcolor="orange" width="100">작성자</th>
			<th bgcolor="orange" width="100">등록일</th>
			<th bgcolor="orange" width="50">조회수</th>
		</tr>
		<c:forEach var="board" items="${board_list}">
		<tr>
			<td align="center">${board.seq}</td>
			<td align="left"><a href="get_board.do?seq=${board.seq}">
				${board.title}</a></td>
			<td align="center">${board.writer}</td>
			<td align="center">${board.regDate}</td>
			<td align="center">${board.cnt}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insert.do">게시글 등록</a>
</body>
</html>