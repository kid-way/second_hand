<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>订单管理</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/zhifu.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/orders.css'></c:url>">
</head>
<body>
	<%@include file="../comment/sellerHead.jsp" %>
	<div class="order">
		<div class="order-head">
			<span><a href="<c:url value='/orderManage'></c:url>">所有</a></span><span><a href="<c:url value='/2/orderManageState'></c:url>">已发货</a></span><span><a href="<c:url value='/1/orderManageState'></c:url>">未发货</a></span><span><a href="<c:url value='/3/orderManageState'></c:url>">已确认收货</a></span>
		</div>
		<div class="order-table">
			<table class="table table-bordered table-striped">
				<thead>
					<th>创建时间</th>
					<th>订单号</th>
					<th>下单商品</th>
					<th>数量</th>
					<th>购买者</th>
					<th>订单状态</th>
					<th>详情</th>
				</thead>
				<tbody>
				<c:forEach items="${smOrderList }" var="smOrder">
					<tr>
						<td><fmt:formatDate value="${smOrder.createTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
						<td>${smOrder.soid }</td>
						<td><img src="<c:url value='/resources/images/${smOrder.item.product.apicname }'></c:url>" width="50px" height="50px"><span>${smOrder.item.product.pname }</span></td>
						<td>${smOrder.item.count }</td>
						<td><a href="<c:url value='/${smOrder.soid }/findBuyMessage'></c:url>">${smOrder.order.user.username }</a></td>
						<td>
							<c:choose>
								<c:when test="${smOrder.state==1 }">
									未发货
								</c:when>
								<c:when test="${smOrder.state==2 }">
									已发货
								</c:when>
								<c:when test="${smOrder.state==3 }">
									已确认收货
								</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${smOrder.state==1 }">
									<a href="<c:url value='/${smOrder.soid }/2/consignment'></c:url>">发货</a>
								</c:when>
								<c:when test="${smOrder.state==2 }">
									待确认收货
								</c:when>
								<c:when test="${smOrder.state==3 }">
									交易成功
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html> 