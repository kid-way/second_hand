<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head">
		<div class="head-content">
			<div class="head-left">
				<a href="<c:url value='/index'></c:url>">首页</a>
			</div>
			<div class="head-search">
				<form action="<c:url value='/1/nameLikeProductsBySid'></c:url>" method="post">
					<input type="text" name="pname" placeholder="商品名称">
					<span>
					<input type="submit" class="btn btn-default" value="搜索">
					</span>
				</form>
			</div>
			<div class="head-mid">
				<a href="<c:url value='/seller/1/sellerindex'></c:url>">我的闲置</a>
			</div>
			<div class="head-right">
				<a href="<c:url value='/toAddProduct'></c:url>">发布闲置</a>
			</div>
			<div class="head-last">
				<a href="<c:url value='/orderManage'></c:url>">订单管理</a>
			</div>
			<div class="head-lasts">
				<c:choose>
					<c:when test="${empty sessionScope.seller}">
						<a href="<c:url value='/seller/login'></c:url>">登录</a>/<a href="<c:url value='/seller/regist'></c:url>">注册</a>
					</c:when>
					<c:otherwise>
						${seller.sname }|<span><a href="<c:url value='/seller/toUpdateSeller'></c:url>">修改个人信息</a></span>|<span><a href="<c:url value='/seller/quit'></c:url>">退出</a></span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
</div>