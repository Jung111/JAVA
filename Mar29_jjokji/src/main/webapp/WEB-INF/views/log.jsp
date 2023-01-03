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
<title>admin/log</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

#log {
	margin: 0 auto;
	margin-top: 10px;
	min-height: 500px;
	width: 900px;
}

#log table {
	width: 900px;
	border-collapse: collapse;
}

tr {
	height: 30px;
	border: 1px solid gray;
}

tr:nth-child(odd){background-color: #c1c1c1 }


tr:hover {
	background-color: #c1c1c1;
}

#paging {
	height: 30px;
	padding-top:10px;
	width: 100%;
	background-color: #c0c0c0;
	margin: 10px 0px;
	text-align: center;
}
</style>
<script type="text/javascript">
	function linkPage(pageNo) {
		var lip = document.getElementById("lip").value;
		var lcate = document.getElementById("lcate").value;
		var search = document.getElementById("search").value;
		location.href = "./log?pageNo=" + pageNo +"&ilp=" +lip+"&lcate="+lcate+"&search"+search;
	}
	function select01(){
		var lip = document.getElementById("lip").value;
		var lcate = document.getElementById("lcate").value;
		//alert(select01.value);
		var search = document.getElementById("search").value;
		location.href='./log?lcate='+lcate+'&search='+search+'&lip='+lip;
	}
	function delIP(){
		document.getElementById("lip").value = "";
		select01();
	}
	function delSearch() {
		document.getElementById("search").value ="";
		select01();
		
	}
</script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h1>총 ${totalList }개의 IP 사용자 입니다 
		<button onclick="location.href='./log'">초기화</button>
	</h1>
	
	<div id="log">
	<c:choose>
		<c:when test="${fn:length(logList) > 0 }">
			<input type="text" name="search" id="search" value="${param.search }"><button type="button" onclick="select01()">내역검색</button><button type="button" onclick="delSearch()">내역지우기</button>
			<input type="text" name="lip" id="lip" value="${param.lip }"><button type="button" onclick="select01()">IP검색</button><button type="button" onclick="delIP()">IP검색지우기</button><button type="button" onclick="select01()">  검 색 </button>
			<table>
				<tr>
					<th style="width: 100px;">번호</th>
					<th style="width: 100px">아이피
						<c:if test="${param.lip ne null  && param.lip ne ''}">
							<small onclick="delIP()">[X]</small>
						</c:if>
					</th>
					<th style="width: 100px">이름</th>
					<th style="width: 200px;">날짜</th>
					<th style="width: 100px;">
						<select name="lcate" id="select01" onchange="select01()">
							<c:choose>
								<c:when test="${fn:length(select01) > 0 }">
							<option value="">항목</option>
							<c:forEach items="${select01 }" var="sele">
								<c:if test="${param.lcate eq sele.lcate }">
									<option value="${sele.lcate }" selected="selected">
									${sele.lcatename }(${sele.count })
									</option>
								</c:if>
								<c:if test="${param.lcate ne sele.lcate }">
									<option value="${sele.lcate }">
									${sele.lcatename }(${sele.count })
									</option>
								</c:if>			
								
							</c:forEach>
								
								</c:when>
								<c:otherwise>
								<option>항목이 없습니다. 다시 시도하세요.</option>
								</c:otherwise>
							</c:choose>
						</select>
						
					</th>
					<th style="width: 300px;">내역</th>
				</tr>
				<c:forEach items="${logList }" var="row">
					<tr>
						<td>${row.lno }</td>
						<td>
							<a href="./log?lip=${row.lip }&lcate=${param.lcate }&search=${param.search }">${row.lip }</a>
						</td>
						<td>${row.lname }</td>
						<td>${row.ldate }</td>
						<td>${row.lcatename }</td>
						<td>${row.letc }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>데이터 없음</h1>
		</c:otherwise>
	</c:choose>

	<div id="paging">
		<ui:pagination paginationInfo="${paginationInfo}" type="text" jsFunction="linkPage" />
	</div>
	</div>


</body>
</html>