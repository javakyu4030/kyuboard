<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kyu 게시판</title>

<!-- 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-thema.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.css"></script>

</head>
<body>

	<form role="form" method="post" autocomplete="off">
		<p>
			<label for="userName">닉네임</label> 
			<input type="text" id="userName" name="userName" value="${member.userName}" />
		</p>
		<p>
			<label for="userPass">새로운 패스워드</label> 
			<input type="password" id="userPass" name="userPass" />
		</p>
		<p>
			<button type="submit">회원정보 수정</button>
		</p>
		<p>
			<a href="/">처음으로</a>
		</p>
		
	</form>
</body>
</html>