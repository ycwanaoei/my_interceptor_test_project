<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath() + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎|Login${header.referer}</title>
    <script type="text/javascript" src="<c:url value='/js/loginPage.js'/>"></script>
</head>
<body>
<div>
    <div>
        <form class="form-horizontal" action="<%=basePath%>tologin" method="post">
            <div class="input-prepend">
                <span class="add-on"><em class="icon-user"></em> </span> <input
                    type="text" class="span3" name="username"
                    value=""
                    placeholder="username">
            </div>
            <br>
            <div class="input-prepend">
                <span class="add-on"><em class="icon-lock"></em> </span> <input
                    type="password" class="span3" name="password"
                    placeholder="password">
            </div>
            <br>
            <input type="submit"
                        value="&nbsp;&nbsp;&nbsp;&nbsp;登陆&nbsp;&nbsp;&nbsp;&nbsp;"
                        class="btn btn-primary" style="margin-right: 154px;">
            <br>
            <div>
                <span>${loginStatus}</span>
            </div>
        </form>
    </div>
</div>
</body>
</html>
