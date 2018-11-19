<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>商品列表</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/list.css'></c:url>">
</head>
<body>
	<%@include file="../comment/head.jsp" %>
	<div class="list-body">
		<div class="list-head">
			<div class="title">
				您已购买的商品
			</div>
		</div>
		<div class="list-content">
			<ul>
				<c:forEach items="${list }" var="product">
					<li>
						<a href="<c:url value='/${product.pid }/detailProduct'></c:url>"><img src="<c:url value='/resources/images/${product.apicname }'></c:url>" alt="" width="177px" height="170px">
							<span>${product.pname }</span>
						</a>
							<span>￥${product.price }</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</body>
</html>