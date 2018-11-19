<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
		<div class="head-content">
			<div class="head-left">
				<a href="<c:url value='/index'></c:url>">首页</a>
			</div>
			<div class="head-search">
				<form action="<c:url value='/1/nameLikeProducts'></c:url>" method="post">
					<input type="text" name="pname" placeholder="商品名称">
					<span>
					<input type="submit" class="btn btn-default" value="搜索">
					</span>
				</form>
			</div>
			<div class="head-mid">
				<a href="<c:url value='/buycar'></c:url>">购物车</a>
			</div>
			<div class="head-right">
				<a href="<c:url value='/3/findProductsByState'></c:url>">已购买</a>
			</div>
			<div class="head-last">
				<a href="<c:url value='/findOrders'></c:url>">我的订单</a>
			</div>
			<div class="head-lasts">
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<a href="<c:url value='/login'></c:url>">登录</a>/<a href="<c:url value='/regist'></c:url>">注册</a>
					</c:when>
					<c:otherwise>
						${user.username }|<span><a href="<c:url value='/toUpdateUser'></c:url>">修改个人信息</a></span>|<span><a href="<c:url value='/quit'></c:url>">退出</a></span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
</div>