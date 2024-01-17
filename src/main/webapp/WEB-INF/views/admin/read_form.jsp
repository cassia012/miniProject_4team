<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=5.0, width=device-width" /> 
<title>Check Sched</title>
<link rel="shortcut icon" href="/images/star.png" /> <%-- /static 기준 --%>
<link href="/css/style.css" rel="Stylesheet" type="text/css"> <!-- /static 기준 -->
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
</head> 
<body>
<c:import url="/menu/top.do" />
    <body>
        <h2>관리자 회원정보 수정</h2>
        <FORM name='frm' method='POST' action='/admin/login.do' enctype="multipart/form-data"  onsubmit="return heckLoginStatus();">
           <c:when test="${sessionScope.id != null }">
               
               <label for="id">아이디:</label>
                <input  name='id' id='id' value="${adminVO.id}"/>
                           
                <label for="name">이름:</label>
                <input  name='mname' id='mname' value="${adminVO.mname}"/>
                
                <label for="password">비밀번호:</label>
                <input  name='passwd' id='passwd'  value="${adminVO.passwd }"/> 
    
                <label for="password">가입일:</label>
                <input name='mdate' id='mdate' value="${adminVO.mdate }"/>
                <input type="submit" value="수정">
            </c:when>
            <c:otherwise>
                  <a href="/admin/login.do">로그인이 필요합니다.</a>
            </c:otherwise>           
            
        </form>
    </body>
 
<jsp:include page="../menu/bottom.jsp" />
</body>
 
</html>