<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h2>欢迎${username}</h2>
    <h2>Hello World!${gamesListSelect} ${gamesListOperate} ${gamesListOperate2}</h2>
    <br>
    <c:forEach items="${userList}" var="user">
        <c:choose>
            <c:when test="${user.userId %2 == 0}">
                <h3 style="color: coral">${user.userId}:${user.userName}:${user.account}</h3><br>
            </c:when>
            <c:otherwise>
                <h3>${user.userId}:${user.userName}:${user.account}</h3><br>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</body>
</html>
