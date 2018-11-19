<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/detail.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/productDetail.css'></c:url>">
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'></c:url>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/productDetail.js'></c:url>"></script>
	
</head>
<body>
	<%@include file="../comment/sellerHead.jsp" %>
	<form action="<c:url value='/${pid }/updateProduct'></c:url>" method="post" enctype="multipart/form-data">
	<div class="productTable">
		<table class="table table-default" >
			<caption>编辑闲置信息&gt;&gt;${msg }</caption>
			
			<tr>
				<td>闲置名称</td>
				<td><input type="text" name="pname" value="${product.pname }"></td>
			</tr>
			<tr>
				<td>闲置价格</td>
				<td>￥<input type="number" name="price" value="${product.price }" min="0.01" step="0.01"></td>
			</tr>
			<tr>
				<td>闲置数量</td>
				<td><input type="number" name="stock" value="${product.stock }" min="1"></td>
			</tr>
			<tr>
				<td colspan="2">分类</td>
			</tr>
			<tr>
				<td>一级分类</td>
				<td>
					<select name="fcid" id="fc">
						<c:forEach items="${fcList }" var="firstCategory">
							<option value="${firstCategory.fcid }" <c:if test="${firstCategory.fcid eq product.fcid }">selected="selected"</c:if>>${firstCategory.fcname }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>二级分类</td>
				<td>
					<select name="scid" id="sc">
						<c:forEach items="${scList }" var="secondCategory">
							<option value="${secondCategory.scid }" <c:if test="${secondCategory.scid eq product.scid }">selected="selected"</c:if>>${secondCategory.scname }</option>
						</c:forEach>
					</select>
			</td>
			</tr>
			<tr>
				<td>闲置图片</td>
				<td><input type="hidden" name="apicname" value="${product.apicname }"><img src="<c:url value='/resources/images/${product.apicname }'></c:url>" width="50px" height="50px"><input type="file" name="pic"></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-success" value="编辑">
				</td>
				<td><a href="<c:url value='/${pid }/deleteProduct'></c:url>" class="btn btn-danger">删除</a></td>
			</tr>
		</table>
	</div>
	</form>
	</body>
</html>
