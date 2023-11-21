<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@page import="com.example.biz.board.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 정보</title>
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
	<h1>게시글 상세 정보</h1>
	<h3>${user_name}님 <a href="logout_proc.do">Log-out</a></h3>
	<hr>
	<form action="update_board.do" method="post" style="display:inline-block;">
		<input type="hidden" name="seq" value="${board.seq}" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" widh="70">제목</td>
				<td align="left"><input type="text" name="title" 
						value="${board.title}" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left">${board.writer}</td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10">
					${board.content}</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left">${board.regDate}</td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left">${board.cnt}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="게시글 수정" /></td>
			</tr>
		</table>	
	</form>
	<hr>
	<a href="insert.do">게시글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="delete_board.do?seq=${board.seq}">게시글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="get_board_list.do">게시글 목록</a>	
</body>
</html>