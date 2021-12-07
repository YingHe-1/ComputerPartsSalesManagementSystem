<%@ page import="entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>

<form action="loginServlet" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <label>
                    <input type="text" name="name"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>密   码：</td>
            <td>
                <label>
                    <input type="password" name="pwd"/>
                </label>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
