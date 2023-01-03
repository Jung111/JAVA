<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	로그인 했다면 표시하기 no : ${sessionScope.no } name : ${sessionScope.name }
	<c:choose>
		<c:when test="${sessionScope.name ne null }">
			${sessionScope.name }님 반갑습니다.
			<a href="./logout">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="./login">로그인해주세요.</a>
		</c:otherwise>
	</c:choose>
	<hr>
	jstl, 	표그리시고
	<c:choose>
		<c:when test="${fn:length(list) > 0 }">
			<table style="width: 900px; border-collapse: collapse;">
		<tr style="background-color: #c0c0c0; height: 30px;">
			<th style="width: 100px;">번호</th>
			<th style="width: 500px">제목</th>
			<th style="width: 100px;">날짜</th>
			<th style="width: 100px;">글쓴이</th>
			<th style="width: 100px;">조회수</th>
		</tr>
		<c:forEach items="${list }" var="row">
		<tr style="border-bottom: 1px solid #c0c0c0; height: 25px;">
			<td>${row.board_no }</td>
			<td>
				<a href="./detail?no=${row.board_no }">
					${row.board_title }<span>(${row.comments })</span>
				</a>
			</td>
			<td>${row.board_date }</td>
			<td>${row.member_name }</td>
			<td>${row.board_views }</td>
		</tr>
		</c:forEach>
	</table>
		</c:when>
		<c:otherwise><h1>데이터 없음</h1></c:otherwise>
	</c:choose>
	
	
	
	컨트롤러 -> login.jsp
	/login get
	
	id
	pw
	btn-> /login POST
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>