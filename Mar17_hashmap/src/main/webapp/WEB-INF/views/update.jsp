<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<form action="">
		<input type="text" name="title" value="${dto.board_title }"><br>
		<textarea rows="" cols="">${dto.board_content }	</textarea><br>
		<button type="submit"></button>


	</form>

</body>
</html>