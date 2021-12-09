<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entity.Users"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建社团</title>

<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap-fileupload.min.css"
	type="text/css" />
<link rel="stylesheet" href="css/bootstrap-timepicker.min.css"
	type="text/css" />

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-fileupload.min.js"></script>
<script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/jquery.autogrow-textarea.js"></script>
<script type="text/javascript" src="js/charCount.js"></script>
<script type="text/javascript" src="js/colorpicker.js"></script>
<script type="text/javascript" src="js/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript" src="js/forms.js"></script>
</head>
<body>
	<script type="text/javascript">
		function check() {
			var clname = document.getElementById('firstname2');
			var clabout = document.getElementById('location2');
			var clubimage = document.getElementById('clubimage');
			if (clname.value == "") {
				alert("请输入社团名称");
				return false;
			} else if (clabout.value == "") {
				alert("请输入社团简介");
				return false;
			} else if (clubimage.value == "") {
				alert("请选择图片");
				return false;
			}
		}
	</script>
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
			<ul class="breadcrumbs">
				<li><a href="welcome.jsp"><i class="iconfa-home"></i></a> <span
					class="separator"></span></li>
				<li><a href="forms.html">社团管理</a> <span class="separator"></span></li>
				<li>新建社团</li>

				<li class="right"><a href="" data-toggle="dropdown"
					class="dropdown-toggle"><i class="icon-tint"></i>主题颜色</a>
					<ul class="dropdown-menu pull-right skin-color">
						<li><a href="default">默认</a></li>
						<li><a href="navyblue">深蓝</a></li>
						<li><a href="palegreen">淡绿色</a></li>
						<li><a href="red">红色</a></li>
						<li><a href="green">绿色</a></li>
						<li><a href="brown">棕色</a></li>
					</ul></li>
			</ul>

			<div class="pageheader">
				<form action="results.html" method="post" class="searchbar">
					<input type="text" name="keyword"
						placeholder="To search type and hit enter..." />
				</form>
				<div class="pageicon">
					<span class="iconfa-pencil"></span>
				</div>
				<div class="pagetitle">
					<h5>社团管理</h5>
					<h1>新建社团</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">

					<div class="widgetbox box-inverse">
						<h4 class="widgettitle">社团</h4>
						<div class="widgetcontent nopadding">
							<%
								Users user = (Users) request.getAttribute("user");
							%>
							<form class="stdform stdform2"
								action="UsersServlet?option=update&id=<%=user.getId()%>"
								method="post">

								<p>
									<label>姓名</label> <span class="field"><input type="text"
										name="name" value="<%=user.getName()%>" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
								<p>
									<label>密码</label> <span class="field"><input type="text"
										name="password" value="<%=user.getPassword()%>"
										id="firstname2" class="input-xxlarge" /></span>
								</p>
								<p>
									<label>电话</label> <span class="field"><input type="text"
										name="tel" value="<%=user.getTel()%>" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
								<p>
									<label>邮箱</label> <span class="field"><input type="text"
										name="email" value="<%=user.getEmail()%>" id="firstname2"
										class="input-xxlarge" /></span>
								</p>
								<p>
									<label>级别</label> <span class="field"><input type="text"
										name="permission_code" value="<%=user.getPermission_code()%>"
										id="firstname2" class="input-xxlarge" /></span>
								</p>
								<%-- <p>
									<label>级别</label> <span class="field"><select
										class="form-control" id="company" name="permission_code">
											<option value="0">----请选择权限----</option>
											<c:forEach items="${companies}" var="company"
												varStatus="companyStatus">
												<option value="${company.id}"
													<c:if test="${company.id eq musicinfo.company.id }">
							selected="selected"
							</c:if>="">${company.companyName}</option>
											</c:forEach>
									</select></span>
								</p> --%>
								<p class="stdformbutton">
									<button class="btn btn-primary" onClick="return check()">提交</button>
									<button type="reset" class="btn">重置</button>
								</p>
							</form>
						</div>
						<!--widgetcontent-->
					</div>
					<!--widget-->

					<jsp:include page="footer.jsp"></jsp:include>

				</div>
				<!--maincontentinner-->
			</div>
		</div>
	</div>
</body>
</html>