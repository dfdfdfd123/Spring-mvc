<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.biz.board.*"%>
<%
	// 1. 사용자 입력 추출
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
 	BoardDO vo = new BoardDO();
 	vo.setSeq(Integer.parseInt(seq));
	
 	BoardService boardService = new BoardServiceImpl();
 	BoardDO board = boardService.getBoard(vo);
	
	// 3. 응답 화면 구성 및 출력
%>        
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
	<a href="logout_proc.jsp">Log-out</a>
	<hr>
	<form action="updateBoard_proc.jsp" method="post" style="display:inline-block;">
		<input type="hidden" name="seq" value="<%= board.getSeq() %>" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" widh="70">제목</td>
				<td align="left"><input type="text" name="title" 
						value="<%= board.getTitle() %>" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><%= board.getWriter() %></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10">
					<%= board.getContent() %></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><%= board.getRegDate() %></td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left"><%= board.getCnt() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="게시글 수정" /></td>
			</tr>
		</table>	
	</form>
	<hr>
	<a href="insertBoard.jsp">게시글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">게시글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">게시글 목록</a>	
</body>
</html>