<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/index.css'></c:url>">
</head>
<body>
	<%@include file="comment/head.jsp" %>
	<div class="nav">
		<div class="nav-left">
			<c:forEach items="${list }" var="firstCategory">
				<div class="menu">
					<div class="menu-head">${firstCategory.fcname }</div>
					<div class="menu-body">
						<ul>
							<c:forEach items="${firstCategory.SClist }" var="secondCategory">
								<li><a href="<c:url value='/${secondCategory.scid }/1/products'></c:url>">${secondCategory.scname }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="nav-mid" id="myCarousel">
			<div id="carousel-example-generic" class="carousel slide">
				<ol class="carousel-indicators radiou">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<a href="#"><img src="resources/images/nvzhuang1.jpg" alt=""></a>
					</div>
					<div class="item">
						<a href="#"><img src="resources/images/xiangji.jpg" alt=""></a>
					</div>
					<div class="item">
						<a href="#"><img src="resources/images/dianshi.jpg" alt=""></a>
					</div>
					<div class="item">
						<a href="#"><img src="resources/images/wanju.jpg" alt=""></a>
					</div>
				</div>
				<a href="#carousel-example-generic" data-slide="prev" class="left carousel-control">
				<span class="glyphicon glyphicon-chevron-left"></span>
				</a>
				<!-- 轮播图上的向后一图切换链接 -->
				<a href="#carousel-example-generic" data-slide="next" class="right carousel-control">
					<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
		</div>
		<div class="nav-right">
			<div class="up">
				<a href="<c:url value='/toAddProduct'></c:url>">发布闲置</a>
			</div>
			<div class="down">
				<a href="<c:url value='seller/1/sellerindex'></c:url>">我的闲置</a>
			</div>
		</div>
	</div>
	<c:forEach items="${list }" var="firstCategory">
	<div class="category">
		<div class="category-up">
			<div class="left">${firstCategory.fcname }</div>
		</div>
		<div class="category-down">
			<div class="category-left">
				<ul>
					<c:forEach items="${firstCategory.SClist }" var="secondCategory">
						<li><a href="<c:url value='/${secondCategory.scid }/1/products'></c:url>">${secondCategory.scname }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="category-right">
				<div class="mid">
					<ul>
						<c:forEach items="${firstCategory.plist }" var="product">
							<li>
								<a href="<c:url value='/${product.pid }/detailProduct'></c:url>"><img src="resources/images/${product.apicname }">
									<span>${product.pname }</span>
								</a><span>￥${product.price }</span>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="right">
					
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	<div class="bottom"></div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
			$(".carousel").carousel({
			interval:2000 //每隔两秒自动轮播
		})
	</script>
</body>
</html>