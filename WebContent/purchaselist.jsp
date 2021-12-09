<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.Purchase"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览进货信息</title>


<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" href="css/responsive-tables.css">

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/responsive-tables.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
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
				<li><a href="dashboard.html"><i class="iconfa-home"></i></a> <span
					class="separator"></span></li>
				<li><a href="table-static.html">进货信息管理</a> <span
					class="separator"></span></li>
				<li>浏览进货信息</li>

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
					<h5>进货信息管理</h5>
					<h1>浏览进货信息</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">
					<h4 class="widgettitle">进货信息列表</h4>
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
								<th class="head0">供应商名称</th>
								<th class="head0">商品名称</th>
								<th class="head0">供应商编号</th>
								<th class="head0">商品编号</th>
								<th class="head0">时间</th>
								<th class="head0">数量</th>
								<th class="head0">进价</th>
								<th class="head1">编辑</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Purchase> list = (List<Purchase>) request.getAttribute("allPurchase");
								if (list == null || list.size() < 1) {
									out.print("没有数据！");
								} else {
									for (Purchase purchase : list) {
							%>
							<tr>
								<td><%=purchase.getSupplier_name()%></td>
								<td><%=purchase.getMerchant_name()%></td>
								<td><%=purchase.getSupplier_code()%></td>
								<td><%=purchase.getMerchant_code()%></td>
								<td><%=purchase.getIn_time()%></td>
								<td><%=purchase.getQuantity()%></td>
								<td><%=purchase.getIn_price()%></td>
								<td class="center"><a
									href="PurchaseServlet?option=edit&id=<%=purchase.getId()%>"><span
										class="iconfa-pencil"></span></a> <span class="center"><%--  <a
										href="PurchaseServlet?option=delete&id=<%=purchase.getId()%>"><span
											class="iconsweets-trashcan"></span></a> --%>
								</span></td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
					<jsp:include page="footer.jsp"></jsp:include>

				</div>
				<!--maincontentinner-->
			</div>
		</div>
	</div>
</body>
</html>