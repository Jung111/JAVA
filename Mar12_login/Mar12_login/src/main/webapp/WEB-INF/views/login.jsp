<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입하세요</title>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function login(){
		//alert("!");
		var id = $("#id").val();
		var pw = $("#pw").val();
		if(id.length < 4 || id == ""){
			alert("아이디를 올바르게 입력하세요.");
			$("#id").focus();
			return false;
		}
		if(pw.length < 4 || pw == ""){
			alert("암호를 올바르게 입력하세요.");
			$("#pw").focus();
			return false;
		}
	}
</script>
<style type="text/css">
#loginF {
	margin: 0 auto;
	margin-top:200px;
	height: 200px;
	width: 400px;
	background-color: #c0c0c0;
	vertical-align: middle;
}
#loginF img{
	height: 200px;
}

#loginI {
	width: 200px;
	height: 200px;
	float: left;
}

#loginInput {
	margin-top: 50px;
	width: 200px;
	height: 200px;
	float: left;
	vertical-align: middle;
	text-align: center;
}
#loginInput input {
	padding:0;
	margin:0;
	width: 90%;
	height:30px;
	box-sizing: border-box;
	margin-bottom: 10px;
}
#loginInput button {
	padding:0;
	margin:0;
	width: 45%;
	height:30px;
}
</style>
</head>
<body>
	<div id="loginF">
		<div id="loginI">
			<img alt="login" src="./images/login.png">
		</div>
		<div id="loginInput">
			<form action="./login" method="post" onsubmit="return login();">
				<input type="text" name="id" id="id" placeholder="아이디를 입력하세요"><br> <input
					type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요"><br>
				<button type="submit">로그인</button>
				<button type="reset">초기화</button>
			</form>
		</div>
	</div>

</body>
</html>