<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>订单</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/zhifu.css'></c:url>">
</head>
<body>
	<%@include file="../comment/head.jsp" %>
	<div class="order">
		<div class="order-head">
			<span>订单号：${order.oid }</span><span>收货人：${order.rname }</span><span>收货人电话：${order.rphone }</span>
		</div>
		<div class="order-head">
			<span>创建时间：<fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span><span>收货地址：${order.raddress }</span>
		</div>
		<c:forEach items="${order.map }" var="map">
			<div class="order-title">
				<span>卖家：${map.key.sname }</span><span>地址：${map.key.address } </span><span>联系方式：${map.key.sphone }</span>
			</div>
			<c:forEach items="${map.value }" var="smOrder">
				<div>
					<table class="table table-bordered">
						<thead>
							<td>订单号</td>
							<td>商品信息</td>
							<td>价格(元)</td>
							<td>数量</td>
							<td>小计(元)</td>
						</thead>
						<tr>
							<td>${smOrder.soid }</td>
							<td><img src="<c:url value='/resources/images/${smOrder.item.product.apicname }'></c:url>" width="50px" height="50px" alt=""><span>${smOrder.item.product.pname }</span></td>
							<td>${smOrder.item.product.price }</td>
							<td>${smOrder.item.count }</td>
							<td>${smOrder.item.subtotal }</td>
						</tr>
					</table>
				</div>
			</c:forEach>	
		</c:forEach>
		<div class="right">
			<div class="right-top">
				<span>总计：${order.total }元</span>
			</div>
		</div>
		<div class="zhifu">
			<a href="<c:url value='/1/${order.oid }/changeOrderState'></c:url>">支付</a><a href="<c:url value='/-1/${order.oid }/changeOrderState'></c:url>">取消订单</a>
		</div>
		</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html> 