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

tr:nth-child(odd) {
	background-color: #c1c1c1
}

tr:hover {
	background-color: #c1c1c1;
}

#paging {
	height: 30px;
	padding-top: 10px;
	width: 100%;
	background-color: #c0c0c0;
	margin: 10px 0px;
	text-align: center;
}
</style>

</head>
<body>
	<%@include file="menu.jsp"%>
	
	<div id="log">
		 <c:forEach items="${tonggye }" var="t">
		 <div>
		<div style="float: left;"> ${t.ldate }</div>
		<div style="background-coldr:red;  float: left;  width: ${t.count } px">${t.count } </div>
		 </div>
		</c:forEach>
	
	
	</div>


</body>
</html>