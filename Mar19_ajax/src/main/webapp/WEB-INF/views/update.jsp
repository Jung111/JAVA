<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
#write{
	margin: 0 auto;
	margin-top:10px;
	height: 500px;
	width:  500px;
	background-color: blue;
}
#write input, #write textarea, #write button{
	margin:0;
	padding:0;
	width: calc(100% - 10px);
	margin: 5px;
	height: 30px;
	box-sizing: content-box;
}
#write textarea{
	height: 350px;
}
</style>
<script type="text/javascript">
	function update2() {
		var title = document.getElementById('title').value;
		var content = document.getElementById('content').value;
		if (title == null || title == "" || title.length < 1) {
			alert("반드시 제목을 입력해야 합니다.");
			document.getElementById('title').focus();
			return false;
		}
		if (content == null || content == "" || content.length < 1) {
			alert("반드시 내용을 입력해야 합니다.");
			document.getElementById('content').focus();
			return false;
		}
		if(!confirm("수정하시겠습니까?")){
			return false;
		}
	}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div id="write">
		<form action="./update" method="post" onsubmit="return update2();">
			<input type="text" name="title" id="title" value="${dto.board_title }" placeholder="제목을 입력하세요">
			<textarea name="content" id="content">${dto.board_content }</textarea>
			<input type="hidden" name="bno" id="bno" value="${dto.board_no }">
			<button type="submit">글쓰기</button>
		</form>
	</div>








</body>
</html>