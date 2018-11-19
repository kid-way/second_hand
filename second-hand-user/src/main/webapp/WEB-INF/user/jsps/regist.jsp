<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册页面</title>
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
		.form-group span:nth-child(2) {
			margin-left:180px;
		}
	</style>
</head>
<body>
	<div class="container">
	<div class="regist">
		<form class="form" action="<c:url value='/toRegist'></c:url>" method="post">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>用户名</label>
					<input id="name" type="text" name="username" class="form-control" placeholder="请输入用户名">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>手机号</label>
					<input id="phone" type="number" name="uphone" class="form-control" placeholder="请输入手机号">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>年龄</label>
					<input type="number" name="age" class="form-control"
					placeholder="请输入年龄">
				</div>
				<div class="col-md-8 col-md-offset-2">
					<label>性别</label>
					<div class="radio">
						<label>
							<input type="radio" name="gender" value="1">男
						</label>
						<label>
							<input type="radio" name="gender" value="0" checked>女
						</label>
					</div>
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<label>密码</label>
					<input type="password" name="password" class="form-control" placeholder="请输入密码">
				</div>
				<div class="col-md-8 col-md-offset-2 form-group">
					<input type="submit" value="注册" class="btn btn-success">
					<span>${msg }</span>
					<span><a href="<c:url value='/login'></c:url>">&gt;&gt;登录&gt;&gt;</a></span>
				</div>
			</div>
		</form>
	</div>	
	</div>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>