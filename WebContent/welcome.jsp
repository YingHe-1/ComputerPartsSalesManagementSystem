<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<link rel="stylesheet" href="./css/style.default.css" type="text/css" />
<link rel="stylesheet" href="./css/responsive-tables.css">
<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="./js/modernizr.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/jquery.cookie.js"></script>
<script type="text/javascript" src="./js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="./js/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="./js/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="./js/responsive-tables.js"></script>
<script type="text/javascript" src="./js/custom.js"></script>

</head>
<body>
	<div class="mainwrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="session.jsp"></jsp:include>
		<div class="leftpanel">
			<div class="leftmenu">
				<ul class="nav nav-tabs nav-stacked">
					<li class="nav-header">导航</li>
					<li class="active"><a href=" "><span
							class="iconfa-laptop"></span>欢迎</a >
					</li>

					<li id="supplier" class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>供应商管理</a >
						<ul>
							<li><a href="newsupplier.jsp">添加供应商</a ></li>
							<li><a href="showSupplierServlet">查询供应商</a ></li>
						</ul>
					</li>

					<li id="client" class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>客户管理</a >
						<ul>
							<li><a href="newcustomer.jsp">添加客户</a ></li>
							<li><a href="showClientServlet">查询客户</a ></li>
						</ul>
					</li>

					<li id="merchant" class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>商品信息管理</a >
						<ul>
							<li><a href="newgoods.jsp">添加商品</a ></li>
							<li><a href="showMerchantsServlet">查询商品</a ></li>
						</ul>
					</li>

					<li id="purchase" class="dropdown"><a href=""><span class="iconfa-pencil"></span>进货管理</a >
						<ul>
							<li><a href="newpurchase.jsp">添加进货信息</a ></li>
							<li><a href="showPurchaseServlet">查询进货信息</a ></li>
						</ul>
					</li>

					<li id="sku" class="dropdown"><a href=""><span class="iconfa-pencil"></span>库存管理</a >
						<ul>
							<!-- <li><a href="newsku.jsp">添加库存</a ></li> -->
							<li><a href="showSkuServlet">查询库存</a ></li>
						</ul>
					</li>

					<li id="user" class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>用户管理</a >
						<ul>
							<li><a href="newuser.jsp">创建用户</a ></li>
							<li><a href="showUsersServlet">查询用户</a ></li>
						</ul>
					</li>

					<li id="order" class="dropdown"><a href=""><span class="iconfa-pencil"></span>订单管理</a >
						<ul>
							<li><a href="neworders.jsp">添加订单</a ></li>
							<li><a href="showOrdersServlet">查询订单</a ></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--leftmenu-->
		</div>
		<!-- leftpanel -->
		<div class="rightpanel">
			<div class="maincontent">
				<div class="maincontentinner">
				    <div class="errortitle">
        				<h4 class="animate0 fadeInUp">欢迎登陆电脑零配件销售管理系统</h4>
        					<div class="errorbtns animate4 fadeInUp">
           						 <a href="../index.jsp" class="btn btn-primary btn-large">主页</a>
        					</div>
   					 </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>