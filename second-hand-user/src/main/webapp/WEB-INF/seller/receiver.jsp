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
	<link rel="stylesheet" href="<c:url value='/resources/css/reciever.css'></c:url>">
</head>
<body>
	<%@include file="../comment/sellerHead.jsp" %>
	<div class="order-table">
		<table class="table table-bordered table-striped">
			<tbody>
				<tr>
					<td>收货人</td>
					<td>${receiver.rname }</td>
				</tr>		
				<tr>
					<td>联系方式</td>
					<td>${receiver.rphone }</td>
				</tr>
				<tr>
					<td>
						收货地址
					</td>
					<td>
						${receiver.raddress }
					</td>
				</tr>
			</tbody>
		</table>
	</div>
  </body>
</html>
	