<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#menu{
	margin: 0 auto;
	height: 30px;
	padding-top:10px;
	width: 100%;
	overflow: hidden;
	background-color: black;
}
#menu nav ul{
	margin:0;
	padding:0;
	list-style-type: none;
	color: white;
}
#menu nav ul li{
	margin:0;
	padding:0;
	float: left;
	padding: 0 10px;
}
#menu nav ul li a{
	display:inline-block;
}
</style>
	<div id="menu">
		<nav>
			<ul>
				<li><a href="">게시판1</a></li>
				<li>게시판2</li>
				<li>게시판3</li>
				<li>게시판4</li>
				<li>게시판5</li>
				<li>게시판6</li>
				<li>게시판7</li>
	<c:choose>
		<c:when test="${sessionScope.name ne null }">
			<li>${sessionScope.name }님 반갑습니다.
			<a href="./logout">로그아웃</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="./login">로그인해주세요.</a></li>
		</c:otherwise>
	</c:choose>
			</ul>
		</nav>
	</div>