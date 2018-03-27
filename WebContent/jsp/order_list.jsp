<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import = "org.tysf.domain.Product" %>
<%@page import = "org.tysf.domain.OrderItem" %>

<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

		<jsp:include page="head.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<h3><strong>我的订单</strong></h3>
						<br>
				<table class="table table-bordered"> 	
					
					<tbody align="center">
					
							
						<%-- <tr>
						<h4>	
						订单编号:<%=orderItem.getItemid() %>
					      </h4>
						
						</tr> --%>
						
						 
						<tr class="warning" align="center">		
						
							  	<th>订单编号</th>
								<th>商品名称</th>					
								<th>商品数量</th>
								<th>商品金额</th>
								
						</tr>	
								
							  <tr align="center">
							  
							    <%
							    List<Product> productItem = (List<Product>)request.getAttribute("productItem");
							    List<OrderItem> orderItem = (List<OrderItem>)request.getAttribute("orderItem");
								int index = orderItem.size();
							    String  itemPid = null;
							    int count=0;
							    String pname=null;
								  double price = 0.0;
								  String  pid = null;
								  String itemid = null;
									for (int i = 0; i <index; i++) {
										pid = orderItem.get(i).getPid();
										itemid = orderItem.get(i).getItemid();
										count=orderItem.get(i).getCount();
										pname = productItem.get(i).getPname();
										price = productItem.get(i).getShop_price();
										pid = productItem.get(i).getPid();
							  %>
							  	<td><%=itemid %></a></td>
							  	<td><a href="${pageContext.request.contextPath }/jsp/product_info.jsp"><%=pname %></td>
							  	<td><%=count %></td>
							  	<td><%=price%></td>
							  
							  </tr>
							  <%} %>
						</tbody>
		
					</table>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
					<li><a href="#">7</a></li>
					<li><a href="#">8</a></li>
					<li><a href="#">9</a></li>
					<li>
						<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</div>
		</div>

		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2010-2017 蓝桥商城 版权所有
		</div>
	</body>

</html>