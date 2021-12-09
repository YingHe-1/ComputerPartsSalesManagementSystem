<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
        <div class="logo">
            <img src="images/logo1.png" alt="" />
        </div>
        <div class="headerinner">
            <ul class="headmenu">
                <li class="right">
                    <div class="userloggedinfo">
                        <img src="images/photos/admin.png" alt="" />
                        <div class="userinfo">
                            <h5>用户名: ${sessionScope.user.name} </h5>
                            <ul>
<%--                                <li><a href="#">超级管理员</a></li>--%>
<%--                                <li><a href="#">已获得最高权限</a></li>--%>
                                <form action="logoutServlet" method="post">
                                    <table>
                                        <tr>
                                            <td><input type="submit" value="登出"/></td>
                                        </tr>
                                    </table>
                                </form>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul><!--headmenu-->
        </div>
    </div>
</body>
</html>