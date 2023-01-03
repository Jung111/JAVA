<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<c:if test="${jjokjiCount ne null }">
		<script type="text/javascript">
			//alert("${jjokjiCount }개의 쪽지가 있습니다.");
			if(confirm("${jjokjiCount }개의 쪽지가 있습니다.\n확인하시겠습니까?")){
				location.href='./jjokji';
			}
		</script>
	</c:if>

	<%@include file="menu.jsp" %>
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
				<a href="./detail.do?no=${row.board_no }">
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
	
		<div id="paging"><%@include file="paging.jsp"%>
			<c:if test="${page lt 10 }"><button disabled="disabled">이전</button></c:if>
			<c:if test="${page gt 10 }"><button onclick="location.href='main?page=${page-10 }&name1=${name1 }&ip=${ip }&cate=${cate }'">이전</button></c:if>
			<c:if test="${page eq 1 }"><button disabled="disabled">◀</button></c:if>
			<c:if test="${page gt 1 }"><button onclick="location.href='main?page=${page-1 }&name1=${name1 }&ip=${ip }&cate=${cate }'">◀</button></c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }"><c:if test="${i eq page }"><button style="background-color: #F5A100;"><b>${i }</b></button> </c:if><c:if test="${i ne page }"><button onclick="location.href='main?page=${i }&name1=${name1 }&ip=${ip }&cate=${cate }'">${i }</button> </c:if></c:forEach>
			<c:if test="${page lt totalPage }"><button onclick="location.href='main?page=${page+1 }&name1=${name1 }&ip=${ip }&cate=${cate }'">▶</button></c:if>
			<c:if test="${page eq totalPage }"><button disabled="disabled">▶</button></c:if>
			<c:if test="${page lt totalPage-9 }">
<button onclick="location.href='main?page=${page+10 }&name1=${name1 }&ip=${ip }&cate=${cate }'">다음</button>
</c:if>
			<c:if test="${page gt totalPage-9 }"><button disabled="disabled">다음</button></c:if>
		</div>
	
	<c:if test="${sessionScope.name ne null }">
		<button onclick="location.href='./write'">글쓰기</button>
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>