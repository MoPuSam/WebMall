<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>

<script type="text/javascript">

 //实现浏览器页面上显示订单信息
$(function(){
	alert("list...")
		var url="${pageContext.request.contextPath}/adminOrdersServlet";
		var parm={"method":"findByOrderID"};
		$.post(url,parm,function(data){
			$.each(data,function(o,n){
				$("orderitem").append("<a>n.oid</a>");
			})
		})
	})


</script>





 <script type="text/javascript">
			function showDetail(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/adminOrdersServlet?method=findByOrderID?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
				}
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
		</script>
	</HEAD>
	<body>
	<table class="table table-bordered" id="order">
	</table>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单时间
									</td>
									<td align="center" width="10%">
										订单数量
									</td>
									<td align="center" width="10%">
										订单总额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										收货地址
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="30%">
										订单详情
									</td>
								<c:forEach var="c" items="${ orderList }" >
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td id="xuhao" style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												
												<c:out value="${c.oid }"></c:out>
												
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${c.ordertime }"></c:out>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${c.total }"></c:out>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${c.money }"></c:out>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${c.money }"></c:out>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:out value="${c.name }"></c:out>
											</td>
											<%-- <td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<c:out value="${c.address }"></c:out>
											</td> --%>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="17%">
												
												<c:if test="${c.state }==1">
													未付款
												</c:if>
												<c:if test="${c.state }==2">
													<%-- <a href="${ pageContext.request.contextPath }/adminOrder_updateState.action?oid=<s:property value="#o.oid"/>"><font color="blue">发货</font></a> --%>
													待发货
												</c:if>
												<c:if test="${c.state }==3">
													等待确认收货
												</c:if>
												<c:if test="${c.state }==4">
													订单完成
												</c:if> 
												
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="but<s:property value="#o.oid"/>" onclick="showDetail(<s:property value="#o.oid"/>)"/>
												<div id="div<s:property value="#o.oid"/>"> 
												
												</div>
											</td>
							
										</tr>
									</c:forEach>
								</tr>
								
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
							<s:if test="pageBean.page != 1">
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a href="${ pageContext.request.contextPath }/adminOrder_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

