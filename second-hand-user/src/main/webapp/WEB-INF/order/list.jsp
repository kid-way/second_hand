<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>订单</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/orders.css'></c:url>">
</head>
<body>
	<%@include file="../comment/head.jsp" %>
	<div class="order">
		<div class="order-head">
			<c:choose>
				<c:when test="${state==5 }">
					<span>所有</span>
				</c:when>
				<c:otherwise>
					<span><a href="<c:url value='/findOrders'></c:url>">所有</a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${state==1 }">
					<span>已支付</span>
				</c:when>
				<c:otherwise>
					<span><a href="<c:url value='/1/findOrdersByState'></c:url>">已支付</a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${state==0 }">
					<span>未支付</span>
				</c:when>
				<c:otherwise>
					<span><a href="<c:url value='/0/findOrdersByState'></c:url>">未支付</a></span>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${state==-1 }">
					<span>已取消</span>
				</c:when>
				<c:otherwise>
					<span><a href="<c:url value='/-1/findOrdersByState'></c:url>">已取消</a></span>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="order-table">
			<table class="table table-bordered table-striped">
				<thead>
					<th>创建时间</th>
					<th>订单号</th>
					<th>总价(元)</th>
					<th>订单状态</th>
					<th>操作</th>
				</thead>
				<tbody>
				<c:forEach items="${orderList }" var="order">
					<tr>
						<td><fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
						<td>${order.oid }</td>
						<td>${order.total }</td>
						<td>
							<c:choose>
								<c:when test="${order.state==-1 }">
									已取消
								</c:when>
								<c:when test="${order.state==0 }">
									未支付
								</c:when>
								<c:when test="${order.state==1 }">
									已支付
								</c:when>
							</c:choose>
						</td>
						<td><a href="<c:url value='/${order.oid }/findOrderByOid'></c:url>">查看详情</a>
							<c:choose>
								<c:when test="${order.state==-1 }">
									<a href="<c:url value='/${order.oid }/deleteOrderByOid'></c:url>">删除</a>
								</c:when>
								<c:when test="${order.state==2 }">
									<a href="<c:url value='/3/${order.oid }/changeOrderStatex'></c:url>">确认收货</a>
								</c:when>
								<c:when test="${order.state==0 }">
									<a href="<c:url value='/1/${order.oid }/changeOrderStatex'></c:url>">支付</a>
									<a href="<c:url value='/-1/${order.oid }/changeOrderStatex'></c:url>">取消</a>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
