<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
    <script language="JavaScript">
        (window.onload = function () {
            var permission = "${sessionScope.user.permission_code}";
            if (permission == "") {
                alert("请登录！")
                window.location.href="login.jsp";
            }
            let delArrSales = ['user','supplier','purchase']
            let delArrWarehouse = ['user', 'order','client']
            if (permission == 44) {
                //销售
                var self = null
                for (let idName of delArrSales) {
                    self = document.getElementById(idName).remove()
                }
            } else if (permission == 4) {
                for (let idName of delArrWarehouse) {
                    self = document.getElementById(idName).remove()
                }
            }
        });
    </script>
</head>
<body>
</body>
</html>
