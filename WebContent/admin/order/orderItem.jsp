<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单详细</title>
</head>
<script type="text/javascript">
//实现浏览器页面上显示订单详细信息
$(function(){
		var url="${pageContext.request.contextPath}/adminOrdersServlet";
		var oid=${pageContext.request.getParameter("oid")};
		var parm={"method":"findByOrderID","oid":oid};
		$.post(url,parm,function(data){
			$.each(data,function(i,n){
				$("orderitem").append("<a>${n.oid}</a>");
			})
		})
	})

</script>
<body>
	<table class="table table-bordered" id="orderitem">
	</table>
	 <div class="divOrder">
		<span>订单号：${orders.oid } <c:choose>
				<c:when test="${orders.state eq 1 }">(未付款)</c:when>
				<c:when test="${orders.state eq 2 }">(已付款)</c:when>
				<c:when test="${orders.state eq 3 }">(未发货)</c:when>
				<c:when test="${orders.state eq 4 }">(已完成)</c:when>
				<c:when test="${orders.state eq 5 }">(全部订单)</c:when>
			</c:choose> 下单时间：${orders.ordertime }
		</span>
	</div>
	<div calss="divRow">
		<div class="divContent">
			<dl>
				<dt>收货人信息</dt>
				<dd>${orders.address }</dd>
			</dl>
		</div>
		<div class="divContent">
			<dl>
				<dt>商品清单</dt>
				<dd>
					<table cellpadding="0" cellspacing="0">
						<tr>
							<th class="tt">商品名称</th>
							<th class="tt" align="left">单价</th>
							<th class="tt" align="left">数量</th>
							<th class="tt" align="left">小计</th>
						</tr>
					
					</table>
				</dd>
			</dl>
		</div>
		<div class="divBtn">
			<span class="spanTotal">合 计：</span> <span class="price_t">&yen;${order.total }</span><br />

			<c:if test="${orders.state eq 2 and btn eq 'deliver' }">
				<a id="deliver"
					href="<c:url value='/admin/AdminOrderServlet?method=deliver&oid=${orders.oid }'/>">发
					货</a>
			</c:if>
			<c:if test="${order.state eq 1 and btn eq 'cancel' }">
				<a id="cancel"
					href="<c:url value='/admin/AdminOrderServlet?method=cancel&oid=${orders.oid }'/>">取
					消</a>
			</c:if>
		</div>
	</div>
</body>
</html>
<table width="100%">
	<s:iterator var="orderItem" value="list">
		<tr>
			<td><img width="40" height="45"
				src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.image"/>"></td>
			<td><s:property value="#orderItem.product.pname" /></td>
			<td><s:property value="#orderItem.count" /></td>
			<td><s:property value="#orderItem.subtotal" /></td>
		</tr>
	</s:iterator>
</table> 