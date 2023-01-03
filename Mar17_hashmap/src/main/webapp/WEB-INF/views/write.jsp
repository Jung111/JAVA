<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<%@include file="menu.jsp" %>
	
	<form action="./write2" method="post">
		<input type="text" name="title">
		<textarea name="content"></textarea>
		
		<button type="submit">글쓰기</button>
	</form>
	
	
	
	
	
	
	
	
	
</body>
</html>