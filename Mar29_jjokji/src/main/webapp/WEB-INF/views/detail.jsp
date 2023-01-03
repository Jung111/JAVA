<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
#write {
	margin: 0 auto;
	margin-top: 10px;
	height: auto;
	min-height:200px;
	width: 500px;
	background-color: #c0c0c0;
}
#commentInput{
	margin: 0 auto;
	margin-top: 10px;
	width: 500px;
	min-height: 80px;
	background-color: #999797;
	vertical-align: middle;
}
#commentInput textarea, .ccommentInput textarea{
	margin: 0;
	padding: 5px;
	min-height: 80px;
	vertical-align: middle;
	width: 430px;
	overflow-y: scroll;
	overflow-x: hidden;
	
}
#commentInput button, .ccommentInput button{
	width: 50px;
	height: 80px;
	vertical-align: middle;
}
#comment{
	margin: 0 auto;
	margin-top: 10px;
	width: 500px;
	height: auto;
	min-height: 10px;
	background-color: #999797;
}

.ccommentInput{
	margin: 0 auto;
	margin-top: 10px;
	width: 500px;
	min-height: 80px;
	padding-left: 50px;
}
.ccommentInput textarea{
	width: 380px;
}
#commentWrite{
	margin: 0 auto;
	height: 20px;
	margin-top: 5px;
	width: 500px;
	background-color: green;
	text-align: center;
}
#cc{
	margin: 0 auto;
	width: 500px;
	height: auto;
	padding-left:25px;
	min-height: 10px;
}
#ccc{
	margin: 0 auto;
	width: 465px;
	height: auto;
	padding:5px;
	min-height: 10px;
	background-color: green;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function update(no, title){
		if(confirm(title + " 글을 수정?")){
			location.href='update?bno='+no;	
		}
	}
	function del(no, title){
		if(confirm(title + " 글을 삭제?")){
			location.href='./delete?bno='+no;
		}
	}
	
	function clike(bno, cno){
		if(confirm("좋아요?")){
			location.href='clike?bno='+bno+'&cno='+cno;
		}
	}
	function cdel(bno, cno){
		if(confirm("삭제?")){
			location.href='cdel?bno='+bno+'&cno='+cno;
		}
	}
	
	$(document).ready(function (){
		$("#commentInput").hide();
		$("#commentWrite").click(function (){
			$(this).hide();
			$("#commentInput").slideDown('slow');
		});		
		$(".cocom").click(function() {
			var bno = $("#bno").val();
			var cno = $(this).children("#cno").val();
			$(this).hide();
			var parent = $(this).parent('div');
			parent.append('<div class="ccommentInput"><form action="./ccomment" method="post"><textarea name="comment"></textarea><input type="hidden" name="cno" value="'+cno+'" ><input type="hidden" name="no" value="'+bno+'" ><button type="submit">대댓글쓰기</button></form></div>');
		});		
	});
	//2021-03-23
	//임베디드 애플리케이션 구현
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div id="write">
		번호 : ${dto.board_no }<br>제목 : ${dto.board_title }
		<hr>
		글쓴이 : ${dto.member_name } <button onclick="location.href='./jjokji?key=write&no=${dto.member_no }'">쪽지보내기</button>/ 글쓴이 번호 : ${dto.member_no } (${dto.board_date })
		<c:if test="${sessionScope.no eq dto.member_no }">
			<button onclick="update(${dto.board_no }, '${dto.board_title }')">수정</button>
			<button onclick="del(${dto.board_no }, '${dto.board_title }')">삭제</button>
		</c:if>
		<hr>
		${dto.board_content }<br>
		<c:if test="${dto.board_file ne null}">
			${dto.board_file }<br>
			<img alt="" src="./upload/${dto.board_file }">
		</c:if>
	</div>
	<c:if test="${sessionScope['name'] ne null && sessionScope['no'] ne null }">	
	<div id="commentWrite">댓글을 쓰러면 눌러주세요.</div>
	<div id="commentInput">
		<form action="./comment" method="post">
			<textarea name="comment"></textarea>
			<button>댓글쓰기</button>
			<input type="hidden" name="no" id="bno" value="${dto.board_no }">
		</form>
	</div>
	</c:if>
	
	<c:forEach items="${comment }" var="c">
		<c:if test="${c.ccno == null }">
	<div id="comment" class="ccomment">
			${c.member_name } / ${c.cdate }/ ${c.clike }
			<c:if test="${sessionScope['no'] ne null && sessionScope['no'] ne c.member_no }">
			<button onclick="return clike(${dto.board_no },${c.cno })">좋아요</button>
			</c:if>
			<c:if test="${sessionScope['no'] eq c.member_no }">
			<button>수정</button><button onclick="cdel(${dto.board_no },${c.cno })">삭제</button>
			</c:if>
			<span class="cocom">대댓글 쓰기<input type="hidden" id="cno" name="cno" value="${c.cno }"></span>
		<br>&nbsp;&nbsp;&nbsp;&nbsp;${c.ccontent }
	</div>
		</c:if>
		
		<c:forEach items="${comment }" var="cc">
		<c:if test="${cc.ccno==c.cno}">
		<div id="cc">
			<div id="ccc">└&nbsp;${cc.member_name } / ${cc.cdate }/ ${cc.clike }
			<c:if test="${sessionScope['no'] ne null && sessionScope['no'] ne cc.member_no }">
			<button onclick="return clike(${dto.board_no },${cc.cno })">좋아요</button></c:if>
			<c:if test="${sessionScope['no'] eq cc.member_no }"><button>수정</button>
			<button onclick="cdel(${dto.board_no },${cc.cno })">삭제</button></c:if>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;${cc.ccontent }
			</div>
		</div>
		</c:if>
		</c:forEach>
	</c:forEach>
	
</body>
</html>