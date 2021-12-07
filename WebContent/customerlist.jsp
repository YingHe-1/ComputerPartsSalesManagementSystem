<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询客户</title>

<link rel="stylesheet" href="./css/style.default.css" type="text/css" />
<link rel="stylesheet" href="./css/responsive-tables.css">

<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="./js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="./js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="./js/jquery.cookie.js"></script>
<script type="text/javascript" src="./js/modernizr.min.js"></script>
<script type="text/javascript" src="./js/responsive-tables.js"></script>
<script type="text/javascript" src="./js/custom.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		// dynamic table

		jQuery('#dyntable2').dataTable({
			"bScrollInfinite" : true,
			"bScrollCollapse" : true,
			"sScrollY" : "300px"
		});

	});
</script>
</head>
<body>
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
							<!-- <li><a href="edituser.jsp">修改用户</a></li> -->
							<li><a href="userlist.jsp">查询用户</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>供应商管理</a>
						<ul>
							<li><a href="newsupplier.jsp">添加供应商</a></li>
							<!-- <li><a href="editsupplier.jsp">修改供应商</a></li> -->
							<li><a href="supplierlist.jsp">查询供应商</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>客户管理</a>
						<ul>
							<li><a href="newcustomer.jsp">添加客户</a></li>
							<!-- <li><a href="editcustomer.jsp">修改客户</a></li> -->
							<li><a href="customerlist.jsp">查询客户</a></li>
						</ul></li>
					<li class="dropdown"><a href=""><span
							class="iconfa-pencil"></span>商品信息管理</a>
						<ul>
							<li><a href="newgoods.jsp">添加商品</a></li>
							<!-- <li><a href="editgoods.jsp">修改商品</a></li> -->
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
				<li><a href=" ">客户管理</a> <span
					class="separator"></span></li>
				<li>查询客户</li>

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
					<span class="iconfa-table"></span>
				</div>
				<div class="pagetitle">
					<h5>客户管理</h5>
					<h1>查询客户</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">
					<h4 class="widgettitle">学生列表</h4>
                <table class="table table-bordered table-infinite" id="dyntable2">
                    <colgroup>
                        <col class="con0" style="align: center; width: 4%" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                    </colgroup>
                    <thead>
                        <tr>
                        <th class="head0 nosort">序号</th>
                            <th class="head0">学生编号</th>
                            <th class="head1">学生姓名</th>
                            <th class="head0">学生性别</th>
                            <th class="head1">学生密码</th>
                            <th class="head0">编辑</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${studentList}" varStatus="status">
                        <tr class="gradeX">
                        <td class="aligncenter">${status.count+(page-1)*perpage}</td>
                            <td>${student.sno}</td>
                            <td>${student.sname}</td>
                            <td>${student.ssex}</td>
                            <td>${student.spassword}</td>
                            <td class="center">
                            <a href="../BackendStudentServlet?option=edit&sno=${student.sno}">
                            <span class="iconfa-pencil"></span></a>
                            &nbsp&nbsp
                            <span class="center">
                            <a href="../BackendStudentServlet?option=delete&sno=${student.sno}"><span class="iconsweets-trashcan"></span></a>
                            </span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
				
				
                        <div class="pagination">
                            ${li}
                        </div><!--pagination-->				
				
				
				
				

					<jsp:include page="footer.jsp"></jsp:include>

				</div>
				<!--maincontentinner-->


			</div>
		</div>


	</div>
</body>
</html>