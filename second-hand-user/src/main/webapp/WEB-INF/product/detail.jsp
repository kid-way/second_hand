<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/detail.css'></c:url>">
</head>
<body>
	<%@include file="../comment/head.jsp" %>
	<div class="detail-body">
		<div class="detail-head">
			<span>卖家：${product.seller.sname }</span><span>地点：${product.seller.address }</span><div class="link">联系方式：${product.seller.sphone }</div>
		</div>
		<div class="detail-left">
			<img src="<c:url value='/resources/images/${product.apicname }'></c:url>" width="350px" height="350px"alt="">
		</div>
		<div class="detail-right">
			<form id="form1" action="<c:url value='/addToBuyCar'></c:url>" method="post">
				<div class="up">
					<ul>
						<li><input type="hidden" name="pid" value="${product.pid }"><li>
						<li><input type="hidden" name="price" value="${product.price }"><li>
						<li><strong>商品名称:</strong><span>${product.pname }</span></li>
						<li><strong>价格:</strong><span><small>￥</small>${product.price }</span></li>
						<li><strong>仅剩:</strong><span>${product.stock }</span></li>
						<li><strong>购买数量:</strong><span><input type="number" name="count" value="1" min="1" max="${product.stock }">件</span></li>
					</ul>
				</div>
			</form>
			<div class="down">
				<a href="#" onclick="gobuycar()">加入购物车</a>
			</div>
		</div>
	</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		function gobuycar(){
			var count = document.getElementsByName("count");
			if(count[0].value>${product.stock}){
				alert("库存不足！");
			}else if(count[0].value<=0){
				alert("购买数量不能小于1！");
			}else{
				var usr = "${user.username}";
				if(usr == ""){
					alert("请先登录！");
					$("#form1").submit();
				}else{
					$("#form1").submit();
					alert("已加入购物车！");
				}
			}
		}
	</script>
</body>
</html>
