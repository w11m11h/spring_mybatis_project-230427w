<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글 내용</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	번 호 : ${content.wnum }<br><br>
	아이디 : ${content.wid }<br><br>
	글쓴이 : ${content.wname }<br><br>
	제 목 : ${content.wtitle }<br><br>
	내 용 : ${content.wcontent }<br><br>
	조회수 : ${content.whit }<br><br>
	등록일 : ${content.wdate }<br><br>
	<hr>
	<c:if test="${delCheck == 1 }">
	<input type="button" value="삭제" onclick="script:window.location.href='delete?wnum=${content.wnum}'">
	</c:if>
	<input type="button" value="목록" onclick="script:window.location.href='list'">	
</body>
</html>