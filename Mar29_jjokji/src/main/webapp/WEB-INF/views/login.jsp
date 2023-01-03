<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="description" content="검색금지">
<meta name="ROBOTS" content="NOINDEX, NOFOLLOW">
<meta name="AdsBot-Google" content="noindex" />
<meta name="googlebot-news" content="noindex" />
<title>가입하세요</title>
<link rel="shortcut icon" href="./resources/images/favicon-32x32.png" type="image/x-icon">
<link rel="icon" href="./resources/images/favicon-32x32.png" type="image/x-icon">
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script type="text/javascript" src="./resources/js/login.js"></script>
<link rel="stylesheet" href="./css/login.css">
<script type="text/javascript">
$(document).ready(function(){
	var userInputId = getCookie("userInputId");
	$("#id").val(userInputId);
	//alert(userInputId);
	if($("#id").val() != ""){
		$("#idSaveCheck").prop('checked', true);
	}
	
	$("#idSaveCheck").change(function (){
		//alert("눌렀습니다.");
		if(     $("#idSaveCheck").is(":checked")     ){
			//alert("눌렸어요");
			//ID불러오기
			var userInputId = $("#id").val();
			//alert("입력한 아이디는 :" + userInputId);
			//쿠키 저장하기
			setCookie("userInputId", userInputId, 7);
		} else {
			//alert("없어요.");
			//쿠기 삭제하기
			deleteCookie("userInputId");
		}
	});
});

function setCookie(cookieName, value, exdays){
	alert("저장할 값은 : " + value);
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var cookieValue = escape(value) 
		+ (    (exdays == null) ? "" : "; expires=" + exdate.toGMTString()  );
	//alert(exdate);
	//alert(cookieValue);
	document.cookie = cookieName + "=" + cookieValue;
}

function getCookie(cookieName) {
	cookieName = cookieName + '=';
	var cookieData = document.cookie;
	var start = cookieData.indexOf(cookieName);
	var cookieValue = '';
	if (start != -1) {
		start += cookieName.length;
		var end = cookieData.indexOf(';', start);
		if (end == -1){
			end = cookieData.length;
		}
		cookieValue = cookieData.substring(start, end);
		//alert(cookieValue);
	}
	return unescape(cookieValue);
}

function deleteCookie(cookieName){
	//alert("지울 이름은 " + cookieName);
	var expireDate = new Date();
	expireDate.setDate(expireDate.getDate() - 1);
	document.cookie = cookieName + "= " + "; expires="
			+ expireDate.toGMTString();
}
</script>
</head>
<body>
	<div id="loginF">
		<div id="loginI">
			<img alt="login" src="./images/login.png">
		</div>
		<div id="loginInput">
			<form action="./login" method="post" onsubmit="return login();">
				<input type="text" name="id" id="id" placeholder="아이디를 입력하세요"><br>
				<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요"><br>
				<input type="checkbox" id="idSaveCheck">ID저장<br>
				
				<c:if test="${param.error ne null }">
					<p style="color: red; font-weight: bolder;">
					정확한 ID와 PW를 입력하세요.
					</p>
				</c:if>
				
				<button type="submit">로그인</button>
				<button type="reset">초기화</button>
			</form>
		</div>
	</div>
	
	<c:if test="${param.error eq 'error' }">
		<script>
			alert("정확한 ID와 PW를 입력하세요.");
		</script>
	</c:if>
	
		<c:if test="${param.error eq 'login' }">
		<script>
			alert("로그인하셔야 합니다.");
		</script>
	</c:if>

</body>
</html>