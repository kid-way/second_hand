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
				${productDto.fcname }<span class="glyphicon glyphicon-menu-right"></span>${productDto.scname }
			</div>
		</div>
		<div class="list-content">
			<ul>
				<c:forEach items="${productDto.pList }" var="product">
					<li>
						<a href="<c:url value='/${product.pid }/detailProduct'></c:url>"><img src="<c:url value='/resources/images/${product.apicname }'></c:url>" alt="" width="177px" height="170px">
							<span>${product.pname }哈哈哈哈哈哈哈哈哈哈哈</span>
						</a>
							<span>￥${product.price }</span>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="list-bottom">
			<div class="content">
				总共${productDto.pageCount }页 
				<c:if test="${page > 1 }">
					<a href="<c:url value='/${productDto.scid }/1/products'></c:url>">首页</a>
					<a href="<c:url value='/${productDto.scid }/${page-1 }/products'></c:url>">上一页</a>
				</c:if>
				<c:if test="${page < productDto.pageCount }">
					<a href="<c:url value='/${productDto.scid }/${page+1 }/products'></c:url>">下一页</a>
					<a href="<c:url value='/${productDto.scid }/${productDto.pageCount }/products'></c:url>">末页</a>
				</c:if>
			</div>
		</div>
	</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</body>
</html>