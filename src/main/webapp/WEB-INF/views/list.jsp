<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글 목록</title>
</head>
<body>
	<h2>자유게시판 글 리스트</h2>
	<hr>
	<h3>총 게시글 수 : ${total }</h3>
	<table border="1" cellspacing="0" cellpadding="0" width="1000">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>글쓴이</th>
			<th width="600">제목</th>
			<th>조회수</th>
			<th>등록일</th>			
		</tr>
		
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.wnum }</td>
			<td>${dto.wid }</td>
			<td>${dto.wname }</td>
			<td>${dto.wtitle }</td>
			<td>${dto.whit }</td>
			<td>${dto.wdate }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="6"><a href="write_form">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>