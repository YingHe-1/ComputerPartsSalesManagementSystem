<%@ page import="entity.LoginState" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>loginRes.jsp</title>
</head>
<body>
<jsp:useBean id="loginRes" type="entity.LoginState" scope="request"/>
<jsp:getProperty name="loginRes" property="state"/>
<a href = "login.jsp"> 点击登录</a>
</body>
</html>