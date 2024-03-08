<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ page import="dev.mvc.calendar.CalendarVO" %>
 <%@ page import="java.util.Calendar" %>
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
<c:import url="../menu/top.jsp" />
<body>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <script>
    var currentDate = new Date();
    var year = currentDate.getFullYear();
    var month = currentDate.getMonth() + 1;

    var data = {
        year: year,
        month: month
    };

    console.log(data);

    $.ajax({
        type: "POST",
        url: "/calendar/month.do",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function(response) {
            console.log("응답:", response);
            console.log("년:", data.year);
            console.log("월:", data.month);
        },
        error: function(error) {
            console.log("Error:", error);
        }
    });
    document.write("현재 날짜: " + year + "년 " + month + "월 " );
    </script>

 <c:choose>
    <c:when test="${not empty data}">
       <h2>${calendarVO.year}년 ${calendarVO.month}월 </h2>        <!-- 현재의 연도와 월 값을 proc로 전달하려면...  -->
        <table>
            <thead>
                <tr>
                    <th>일</th>
                    <th>월</th>
                    <th>화</th>
                    <th>수</th>
                    <th>목</th>
                    <th>금</th>
                    <th>토</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="calendarVO" items="${read_month}">
                    <c:choose>
                        <c:when test="${calendarVO.dayOfWeek eq 1}"><tr></c:when>
                    </c:choose>
                    <td>${calendarVO.day}</td>
                    <c:choose>
                        <c:when test="${calendarVO.dayOfWeek eq 7}"></tr></c:when>
                    </c:choose>
                </c:forEach>
            </tbody>
        </table>
</c:when>
    <c:otherwise>
        <p>조회된 달력이 없습니다.</p>
    </c:otherwise> 
</c:choose>

</body>
 
<jsp:include page="../menu/bottom.jsp" />
</body>
 
</html>