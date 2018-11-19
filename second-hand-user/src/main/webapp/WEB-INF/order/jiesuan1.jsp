<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/jiesuan.css'></c:url>">
</head>
<body>
	<%@include file="../comment/head.jsp" %>
	<form id="form3" action="<c:url value='/tijiao'></c:url>" method="post">
		<div class="message">
			<div class="address">收货地址：<input type="text" name="raddress"></div>
			<div class="phone">手机号：<input type="number" name="rphone" value="${user.uphone }"></div>
			<div class="linker">联系人：<input type="text" name="rname" value="${user.username }"></div>
		</div>
		<table class="table table-bordered">
			<thead>
				<th>商品信息</th>
				<th>单价(元)</th>
				<th>数量</th>
				<th>小计(元)</th>
			</thead>
			<c:forEach items="${itemDto.items }" var="item">
				<tr>
					<input type="hidden" name="iid" value="${item.iid}">
					<td><a href="<c:url value='/${item.product.pid }/detailProduct'></c:url>"><img src="<c:url value='/resources/images/${item.product.apicname}'></c:url>" width="50px" height="50px" alt=""><span>${item.product.pname }</span></a></td>
					<td>${item.product.price }</td>
					<td>${item.count }</td>
					<td>${item.subtotal }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="down">
		<div class="down-left">总计：${itemDto.total }元</div>
	</div>
	<div class="down">
		<div class="down-right"><a href="#" onclick="tijiao()">提交订单</a></div>
	</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		function tijiao(){
			$("#form3").submit();
		}
	</script>
</body>
</html>