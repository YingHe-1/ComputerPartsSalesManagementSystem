<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>

<link rel="stylesheet" href="./css/style.default.css" type="text/css" />
<link rel="stylesheet" href="./css/bootstrap-fileupload.min.css"
	type="text/css" />
<link rel="stylesheet" href="./css/bootstrap-timepicker.min.css"
	type="text/css" />

<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/bootstrap-fileupload.min.js"></script>
<script type="text/javascript" src="./js/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="./js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="./js/jquery.validate.min.js"></script>
<script type="text/javascript" src="./js/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="./js/jquery.autogrow-textarea.js"></script>
<script type="text/javascript" src="./js/charCount.js"></script>
<script type="text/javascript" src="./js/colorpicker.js"></script>
<script type="text/javascript" src="./js/ui.spinner.min.js"></script>
<script type="text/javascript" src="./js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.cookie.js"></script>
<script type="text/javascript" src="./js/modernizr.min.js"></script>
<script type="text/javascript" src="./js/custom.js"></script>
<script type="text/javascript" src="./js/forms.js"></script>
</head>
<body>
	<script type="text/javascript">
		function check() {

		}
	</script>
	<div class="mainwrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="leftpanel">
			<div class="leftmenu">
				<ul class="nav nav-tabs nav-stacked">
					<li class="nav-header">导航</li>
					<li class="active"><a href="welcome.jsp"><span
							class="iconfa-laptop"></span>欢迎</a></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>用户管理</a>
						<ul>
							<li><a href="newuser.jsp">创建用户</a></li>
							<li><a href="edituser.jsp">修改用户</a></li>
							<li><a href="showUsersServlet">查询用户</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>供应商管理</a>
						<ul>
							<li><a href="newsupplier.jsp">添加供应商</a></li>
							<li><a href="editsupplier.jsp">修改供应商</a></li>
							<li><a href="supplierlist.jsp">查询供应商</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>客户管理</a>
						<ul>
							<li><a href="newcustomer.jsp">添加客户</a></li>
							<li><a href="editcustomer.jsp">修改客户</a></li>
							<li><a href="showClientServlet">查询客户</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>商品信息管理</a>
						<ul>
							<li><a href="newgoods.jsp">添加商品</a></li>
							<li><a href="editgoods.jsp">修改商品</a></li>
							<li><a href="goodslist.jsp">查询商品</a></li>
						</ul></li>
						<li ><a href=""><span
							class="iconfa-pencil"></span>进货管理</a>
						</li>
						<li ><a href=""><span
							class="iconfa-pencil"></span>销售管理</a>
						</li>
						<li ><a href=""><span
							class="iconfa-pencil"></span>库存管理</a>
						</li>
				</ul> 
			</div>
			<!--leftmenu-->
    </div><!-- leftpanel -->
		<div class="rightpanel">
			<ul class="breadcrumbs">
				<li><a href="welcome.jsp"><i class="iconfa-home"></i></a> <span
					class="separator"></span></li>
				<li><a href=" ">商品信息管理</a> <span class="separator"></span></li>
				<li>修改商品</li>

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
					<h5>商品信息管理</h5>
					<h1>修改商品</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">

					<div class="widgetbox box-inverse">
						<h4 class="widgettitle">成绩</h4>
						<div class="widgetcontent nopadding">
							<form class="stdform stdform2" method="post"
								action="../BackendStudentCourse.do?option=save&cno=${ studentcourse.cno}&sno=${ studentcourse.sno}">
								<p>
									<label>学号</label> <span class="field"><input
										type="text" name="sno" id="firstname2"
										class="input-xxlarge" readonly="true" value="${ studentcourse.sno}"/></span>
								</p>
								
								<p>
									<label>课程号</label> <span class="field"><input
										type="text" name="cno" id="firstname2"
										class="input-xxlarge" readonly="true" value="${ studentcourse.cno}"/></span>
								</p>
								
								<p>
									<label>成绩</label> <span class="field"><input
										type="text" name="SCgrade" id="firstname2"
										class="input-xxlarge" value="${ studentcourse.SCgrade}"/></span>
								</p>

								<p class="stdformbutton">
									<button class="btn btn-primary" onClick="return check()">保存</button>
									<button type="reset" class="btn">重置</button>
								</p>
								${message}
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
	</div>
</body>
</html>