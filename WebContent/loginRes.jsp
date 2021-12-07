<%@ page import="entity.LoginState" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>loginRes.jsp</title>
</head>
<body>
<%
    LoginState loginRes = (LoginState) request.getAttribute("loginState");
%>

<%=loginRes.getState() %>