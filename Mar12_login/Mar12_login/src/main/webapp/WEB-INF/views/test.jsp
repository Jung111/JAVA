<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.out {
	width: 200px;
	height: 60px;
	background-color: yellow;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="out">
		<p>마우스를 여기로 올려보세요.</p>
		<p>0</p>
	</div>

<script type="text/javascript">
	/* $(document).ready(function() {
		$("h1").click(function() {
			$(this).hide();
		});
	}); */
	var i = 0;
	$(".out").mouseover(function(){
		$("p:first", this).text("올라왔습니다.");
		$("p:last", this).text(++i);
	});
</script>


	<marquee>흘러간다~~~</marquee>
	<h1>test1</h1>
	<h1>test2</h1>
	<h1>test3</h1>
	<h1>test4</h1>
	<h1>test5</h1>
	show() 표시 slideup() html "h1" id "#" class "." 이벤트 종류 keypress keydown
	keyup click dbclick mouseenter mouseleave submit change focus blur
	resize load unload scroll
</body>
</html>