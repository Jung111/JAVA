<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	제목 : ${dto.board_title }<br>
	글번호: ${dto.board_no }<br>
	날짜:${dto.board_date }<br>
	글쓴이:${dto.member_name }  /  글쓴이번호 : ${dto.member_no } <br>
	
	<c:if test="${sessionScope.no eq  member_no }">
	<button onclick="location.href='./update?bno=${dto.board_no}'">수정</button>
	<img alt ="del"  src="./images/delete.png" onclick="location.href='./delete?bno=${dto.board_no}">
	</c:if>
	<br>
	<hr>	
	<!-- 삭제,수정 -->
	
	<input type="button" value="삭제" onclick="del(${board.seq})">
	<input type="button" value="글 목록" onclick="location.href='board';">

</body>
</html>