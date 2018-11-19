<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户登录</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		body {
			background-color: #666;
		}
		.login {
			margin-top: 200px;
			background-color: #fff;
			height: 260px;
		}
		form {
			margin: 55px;
		}
		.btn {
			margin-top: 10px;
		}
		span {
			display:inline-block;
			margin-top:10px;
			color: red;
		}
		.input-group span {
			margin-left: 120px;
			font-size: 13px;
		}
		
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4 login">
				<form action="<c:url value='/toLogin'></c:url>" method="post">
					<div class="input-group">
						<label for="username">用户名</label>
						<input type="text" name="username" placeholder="请输入用户名" class="form-control">
					</div>
					<div class="input-group">
						<label for="password">密码</label>
						<input type="password" name="password" placeholder="请输入密码" class="form-control">
					</div>
					<div class="input-group">
						<input type="submit" value="登录" class="btn btn-md btn-primary"><span><a href="<c:url value='/regist'></c:url>">&gt;&gt;注册&gt;&gt;</a></span>
					</div><span>${msg }</span>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>