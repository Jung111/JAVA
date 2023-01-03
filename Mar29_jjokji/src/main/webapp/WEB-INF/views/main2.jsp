<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판2</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript">
	function linkPage(pageNo) {
		location.href = "./main2?pageNo=" + pageNo;
	}
</script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.0.js"></script>

<script type="text/javascript">
	$(document).ready(function (){
		//alert("!");
		//$("#maintable").empty();
		//$("#maintable").append("<h1>지웠어요</h1>");
		var num = 1;
		ajax1(num);
		//alert(num);
	});
	function ajax1(num){
		$.ajax({
			url : "./mainAjax",
			type : "POST",
			cache : false,
			dataType : "json",
			data : {'pageNo' : num},
			success : function(data){
				//alert("오는 값 : " + data.pageNo);
				//alert("오는 값 : " + data.totalList);
				var html = "<table><tr><td>번호</td><td>제목</td><td>날짜</td><td>글쓴이</td><td>조회수</td></tr>";
				var list = data.boardList;
				for(var i=0; i < list.length; i++){
					html += "<tr><td>"+list[i].board_no+"</td>";
					html += "<td>"+list[i].board_title+"</td>";
					html += "<td>"+list[i].board_date+"</td>";
					html += "<td>"+list[i].member_name+"</td>";
					html += "<td>"+list[i].board_views+"</td>";
					html += "</tr>";
				}
				
				html += "</table>";
				//alert(html);
				$("#maintable").empty();
				$("#maintable").append(html);
				//$("#maintable").html(html);
				
				var pageNo = data.pageNo;
				var totalCount = data.totalList;
				var totalPage = parseInt(totalCount / 10);
			
				if(totalCount % 10 != 0){
					totalPage += 1;
				}
				var startPage = parseInt(pageNo / 10);
				if(pageNo % 10 != 0){
					startPage = startPage * 10 + 1;
				}
				if(pageNo % 10 == 0){
					pageNo -= 9;
				}
				var endPage = startPage + 10;
				if((startPage + 10) > totalPage){
					endPage = totalPage;
				}
				
				var paging = "<button ";
				
				if(pageNo < 10){
					paging += "disabled=\"disabled\"";
				}else{
					paging += "onclick=\"location.href='main2?pageNo="+pageNo+"'\"";
				}
				paging += ">이전</button>"
				if(pageNo > 1){
					paging += "<button onclick='ajax1("+(pageNo-1)+")'";
				}else{
					paging += "<button disabled=\"disabled\""; 
				}
				paging += ">◀</button>";
				
				//alert("startPage" + startPage);
				//alert("endPage"+endPage);
				
				for(var i = startPage; i <= endPage; i++){
					if(i != pageNo){
						paging += "<button onclick='ajax1("+i+")'>"+i;
					}else{
						paging += "<button style='background-color:#F5A100;'><b>"+i+"</b>";
					}
					paging += "</button>";
				}
				$("#paging").append(paging);
			},
			error : function(request, status, error){
				alert("에러입니다.");
			}
		});
		//alert("!");
	}
	
</script>

</head>
<body>
	<%@include file="menu.jsp"%>
	<div id="maintable">
	<!-- 비어있어요 -->
	</div>
	
	<div id="paging">
	
	</div>
	
	<ui:pagination paginationInfo="${paginationInfo}" type="text"
		jsFunction="linkPage" />
	<!-- 여기까지가 AJAX로 변경될 곳 입니다. -->
	

	<c:if test="${sessionScope.name ne null }">
		<button onclick="location.href='./write'">글쓰기</button>
	</c:if>














</body>
</html>