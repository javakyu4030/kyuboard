<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 	<!-- 날짜 방식 변경 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>

<!-- 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-thema.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.css"></script>

</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>


<table>
	<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.bno}</td>
				<td>
					<a href="/board/view?bno=${list.bno}">${list.title}</a>
				</td>
				
				<td>
					<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" />
				</td>
				<td>${list.writer}</td>
				<td>${list.viewCnt}</td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>

<div>

	<c:if test="${page.prev}">
	 	<span>[ <a href="/board/listPage?num=${page.startPageNum - 1}">이전</a> ]</span>
	</c:if>

	<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
		 <span>
 
			  <c:if test="${select != num}">
			  	 <a href="/board/listPage?num=${num}">${num}</a>
			  </c:if>    
		  
			  <c:if test="${select == num}">
			  	 <b>${num}</b>
			  </c:if>
		    
		 </span>
	</c:forEach>
	
	<c:if test="${page.next}">
		 <span>[ <a href="/board/listPage?num=${page.endPageNum + 1}">다음</a> ]</span>
	</c:if>


	<%--<c:forEach begin="1" end="${pageNum}" var="num">
		<span>
			<a href="/board/listPage?num=${num}">${num}</a> 
		</span>
	</c:forEach>  --%>
</div>

</body>
</html>