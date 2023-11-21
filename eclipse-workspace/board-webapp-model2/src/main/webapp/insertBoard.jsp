<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<style>
body {
	max-width: 800px;
	margin: auto;
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
	<h1>게시글 등록</h1>
	<a href="logout_proc.do">Log-out</a>
	<hr>
	<form action="register_board.do" method="post" style="display:inline-block;">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" widh="70">제목</td>
				<td align="left"><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input type="text" name="writer" size="10" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="게시글 등록" /></td>
			</tr>
		</table>	
	</form>
	<hr>
	<a href="get_board_list.do">게시글 목록</a>	
</body>
</html>