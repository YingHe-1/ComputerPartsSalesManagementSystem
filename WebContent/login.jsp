<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>电脑零配件销售管理-登录</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/style.shinyblue.css" type="text/css" />
<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="./js/modernizr.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/jquery.cookie.js"></script>
<script type="text/javascript" src="./js/custom.js"></script>
<script type="text/javascript">
	function check() {
		var username = document.getElementById('username');
		var password = document.getElementById('password');
		if (username.value === "") {
			alert("请输入用户名");
			return false;
		} else if (password.value === "") {
			alert("请输入密码");
			return false;
		}
	}
	function sign() {
		window.location.href="signin.jsp";
	}
</script>
</head>
<body class="loginpage">
	<div class="loginpanel">
		<div class="loginpanelinner">
			<div class="logo animate0 bounceIn">
				<img src="images/logo1.png" alt="" />
			</div>
			<form id="login" action="loginServlet" method="post">
				<div class="inputwrapper animate1 bounceIn">
					<input type="text" name="name" id="username"
						placeholder="用户名" />
				</div>
				<div class="inputwrapper animate2 bounceIn">
					<input type="password" name="pwd" id="password"
						placeholder="密码" />
				</div>
				<div class="inputwrapper animate3 bounceIn">
					<button name="submit" onClick="return check()">登录${message}</button>
				</div>
			</form>
			<div class="inputwrapper animate4 bounceIn">
				<button name="submit" onClick="return sign()">注册</button>
			</div>
		</div>
		<!--loginpanelinner-->
	</div>
	<!--loginpanel-->

	<div class="loginfooter">
		<p>&copy; 2021.电脑零配件销售管理系统 All Rights Reserved.</p>
	</div>
</body>
</html>