<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改个人信息</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style type="text/css">
		body {
			background-color: #666;
		}
		.regist {
			width: 500px;
			height: 500px;
			margin: 100px auto;
		}
		form {
			background-color: #fff;
			padding: 10px;
		}
	</style>
</head>
<body>
	<div class="container">
	<div class="regist">
		<form id="form1" class="form" action="<c:url value='/seller/update'></c:url>" method="post">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>卖家名称</label>
					<input id="name" type="text" name="sname" class="form-control" placeholder="请输入卖家名称" value="${seller.sname }">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>手机号</label>
					<input id="phone" type="number" name="sphone" class="form-control" placeholder="请输入手机号" value="${seller.sphone }">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>年龄</label>
					<input id="age" type="number" name="age" class="form-control"
					placeholder="请输入年龄" value="${seller.age }">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>地址</label>
					<input id="address" type="text" name="address" class="form-control"
					placeholder="请输入地址" value="${seller.address }">
				</div>
				<div class="col-md-8 col-md-offset-2">
					<label>性别</label>
					<div class="radio">
						<c:choose>
							<c:when test="${seller.gender==1 }">
								<label>
									<input type="radio" name="gender" value="1" checked>男
								</label>
								<label>
									<input type="radio" name="gender" value="0">女
								</label>
							</c:when>
							<c:when test="${seller.gender==2 }">
								<label>
									<input type="radio" name="gender" value="1">男
								</label>
								<label>
									<input type="radio" name="gender" value="0" checked>女
								</label>
							</c:when>
						</c:choose>
					</div>
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>密码</label>
					<input id="password" type="password" name="password" class="form-control" placeholder="请输入密码" value="${seller.password }">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<input type="submit" class="btn btn-success" value="修改">
					<span>${msg }</span>
				</div>
			</div>
		</form>
	</div>	
	</div>
</body>
</html>