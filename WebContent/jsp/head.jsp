<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
<!--验证用户名是否存在-->
	$("#username").blur(function(){
		var username=$("#username").val();
		if(username!=null){
			var url="${pageContext.request.contextPath}/userServlet";
			var data={"method":"checkUsername","username":username};
			$.post(url,data,function(data){
	 			if(data==1){
	 				$("#userMsg").text("用户名可用").css("color",red);
	 			}else if(data==2){
	 				$("#userMsg").text("用户名已被占用").css("color",green);
	 			}
			});
		}/* else{
			$("#userMsg").val("用户名不能为空");
		} */
	});
$(function(){
	 var url = "${pageContext.request.contextPath}/categoryServlet";
	 var params = {"method":"findAll"};
	 $.post(url,params,function(data){
		/*  http://www.jb51.net/article/54570.htm  */
		 $.each($.parseJSON(data),function(i,n){
			 $("#menu").append("<li><a href='${pageContext.request.contextPath}/productServlet?method=findAll&page=1&cname="+n.cname+"&cid="+n.cid+"'>"+n.cname+"</a></li>");
		 });
	 });
 });
</script>
</head>
<body>
	<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/logo.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
						<c:if test="${empty loginUser}">
						<li><a href="${pageContext.request.contextPath}/userServlet?method=loginUI">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/userServlet?method=registUI">注册</a></li>
						</c:if>
						<c:if test="${not empty loginUser}">
						欢迎：${loginUser.name},
						<li><a href="cart.htm">购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/ordersServlet?method=findUserOrder&uid=${loginUser.uid}">我的订单</a></li>
						<li><a href="${pageContext.request.contextPath}/userServlet?method=logout">退出</a></li>
						</c:if>
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath}/indexServlet">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="menu">
								<!-- <li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li>
								<li><a href="#">电脑办公</a></li> -->
								<%--激活<li class='active' >--%>
								<%-- <c:forEach items="${allCategory}" var="category">
									<li value="${category.cid}"><a href="#">${category.cname}</a></li>
								</c:forEach> --%>
							</ul>
							<form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/productServlet">
								<input type="hidden" name="method" value="findByName">
								<div class="form-group">
									<input type="text" name="pname" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-default">查询商品</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
	
</body>
</html>