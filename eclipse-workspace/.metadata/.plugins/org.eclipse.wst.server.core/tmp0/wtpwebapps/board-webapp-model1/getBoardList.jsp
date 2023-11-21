<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.biz.board.*, java.util.*" %>    
<%
	// 1. 사용자 입력 추출
	// 2. DB 연동 처리
 	BoardService boardService = new BoardServiceImpl();
	List<BoardDO> boardList = boardService.listBoard();
	
	// 3. 응답 화면 구성 및 출력
%>    
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
	<h3>테스트님 환경합니다...<a href="logout_proc.jsp">Log-out</a></h3>
	
	<!-- 검색 폼 -->
	<form action="getBoardList.jsp" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
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
		<% for(BoardDO board : boardList) { %>
		<tr>
			<td align="center"><%= board.getSeq() %></td>
			<td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq() %>">
				<%= board.getTitle() %></a></td>
			<td align="center"><%= board.getWriter() %></td>
			<td align="center"><%= board.getRegDate() %></td>
			<td align="center"><%= board.getCnt() %></td>
		</tr>
		<% } %>
	</table>
	<br>
	<a href="insertBoard.jsp">게시글 등록</a>
</body>
</html>