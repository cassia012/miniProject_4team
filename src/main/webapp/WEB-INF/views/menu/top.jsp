<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="dev.mvc.admin.AdminVO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList" %>

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
    <div>
        <h2>CheckSched</h2>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link"
                        href="#">월간</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="#">주간</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="#">일간</a></li>
                </ul>

                <ul class="navbar-nav float-right">
                    <li class="nav-item"><c:choose>
                            <c:when test="${sessionScope.id != null}">
                                <p class="nav-link">로그인 : ${sessionScope.id }</p>
                                <img src="/menu/images/lock.png"
                                    class="icon"
                                    style='margin-left: 30px'>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link"
                                    href="/admin/login.do">Not
                                    logged in</a>
                            </c:otherwise>
                        </c:choose></li>
                </ul>
            </div>
        </nav>

    </div>
</body>
</html>