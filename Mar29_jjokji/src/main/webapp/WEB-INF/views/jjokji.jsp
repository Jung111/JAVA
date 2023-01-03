<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지</title>
<style type="text/css">
body {
   margin: 0;
   padding: 0;
}

#sendjj {
   margin: 0 auto;
   margin-top: 50px;
   height: 300px;
   width: 300px;
   background-color: gray;
}

#sendjj textarea, #sendjj button {
   margin: 0;
   padding: 0;
   width: 100%;
   height: 50px;
}

#sendjj textarea {
   height: 250px;
}

#listjj {
   margin: 0 auto;
   margin-top: 50px;
   min-height: 100px;
   max-height: 500px;
   width: 500px;
   background-color: gray;
}

#listjj table {
   width: 100%;
   border-collapse: collapse;
}

#detailjj {
   margin: 0 auto;
   margin-top: 50px;
   min-height: 100px;
   max-height: 500px;
   width: 500px;
   background-color: gray;
}
</style>
</head>
<body>
   <%@include file="menu.jsp"%>
   <c:choose>
      <c:when test="${sessionScope.no ne null && sessionScope.name ne null}">
         <c:choose>
            <c:when test="${param.key eq 'list' }">
               <div id="listjj">
                  <c:choose>
                     <c:when test="${fn:length(list) > 0 }">
                        <table border="1">
                           <tr>
                              <td>보낸 사람</td>
                              <td>보낸 날짜</td>
                              <td>내용</td>
                              <td>수신확인</td>
                           </tr>
                           <c:forEach items="${list }" var="var">
                              <tr>
                                 <td>${var.songname }</td>
                                 <td>${var.jsongdate }</td>
                                 <td><a href="./jjokji?key=detail&no=${var.jno }">${var.jtext }</a></td>
                                 <td><c:if test="${var.suchk  eq 'Y'}">읽음</c:if><c:if test="${var.suchk eq 'N'}">안읽음</c:if>
                                    <button onclick="location.href='./jjokji?key=delete&no=${var.jno }'">삭제</button>
                                 </td>
                              </tr>
                           </c:forEach>
                        </table>

                     </c:when>
                     <c:otherwise>
                        <h1>받은 쪽지가 없습니다.</h1>
                     </c:otherwise>
                  </c:choose>
               </div>
            </c:when>
            
            <c:when test="${param.key eq 'write'}">
            		오는 no : ${param.no }
               <div id="sendjj">
                  <form action="./jjokji" method="post">
                     <textarea name="msg"></textarea>
                     <input type="hidden" name="key" value="sendMsg">
                     <input type="hidden" name="no" value="${param.no }"><br>
                     <button type="submit">쪽지보내기</button>
                  </form>
                  <button onclick="location.href='./jjokji?key=list'">쪽지리스트로</button>
               </div>
            </c:when>

            <c:when test="${param.key eq 'detail' }">
               <div id="detailjj">
                  <table>
                     <tr>
                        <th>보낸사람</th>
                        <td>${detail.songname }</td>
                     </tr>
                     <tr>
                        <th>날짜</th>
                        <td>${detail.jsongdate }</td>
                     </tr>
                     <tr>
                        <th>내용</th>
                        <td>${detail.jtext }</td>
                     </tr>
                  </table>
                  <button onclick="location.href='./jjokji?key=write&no=${detail.songmno }'">${detail.songname }님에게 답장</button>
                  <button onclick="location.href='./jjokji?key=write&no=${detail.jno }'">삭제</button>
                  <button onclick="location.href='./jjokji?key=list'">쪽지리스트로</button>
               </div>
            </c:when>

         </c:choose>

      </c:when>
      <c:otherwise>
         <c:redirect url="./login">
            <c:param name="error" value="error" />
         </c:redirect>
      </c:otherwise>
   </c:choose>

</body>
</html>