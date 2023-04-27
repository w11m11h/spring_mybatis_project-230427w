<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
</head>
<body>
	<%
		String sessionId = (String) session.getAttribute("sessionId"); //null값이 들어오는경우 toString()을 사용하면 안되고 강제 형변환을 해야함
		if(sessionId == null) {
	%>
		<script type="text/javascript">
			alert('로그인 한 회원만 글쓰기가 가능합니다.');
			window.location.href='login';
		</script>
	<%
		}
	%>
</body>
</html>