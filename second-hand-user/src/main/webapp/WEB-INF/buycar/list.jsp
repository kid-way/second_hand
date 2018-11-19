<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/resources/css/head.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/bottom.css'></c:url>">
	<link rel="stylesheet" href="<c:url value='/resources/css/buycar.css'></c:url>">
</head>
<body>
	<%@include file="../comment/head.jsp" %>
	<table class="table table-bordered">
		<form action="<c:url value='/deleteItems'></c:url>" id="form2" method="post">
			<thead>
				<th><input type="checkbox" id="checkbox1"></th>
				<th>商品信息</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</thead>
			<c:forEach items="${items }" var="item">
				<tr>
					<td><input type="checkbox" name="iid" value="${item.iid }"></td>
					<td><a href="<c:url value='/${item.product.pid }/detailProduct'></c:url>"><img src="<c:url value='/resources/images/${item.product.apicname }'></c:url>" width="50px" height="50px" alt=""><span>${item.product.pname }</span></a></td>
					<td>${item.product.price }</td>
					<td>${item.count }</td>
					<td>${item.subtotal }</td>
					<td><a href="<c:url value='/${item.iid }/deleteItem'></c:url>">移除</a></td>
				</tr>
			</c:forEach>
		</form>
	</table>
	<div class="down"> 
		<div class="down-left"><a href="#" onclick="fun()">批量删除&gt;&gt;</a></div><span>${msg }</span>
		<div class="down-right"><a href="#" onclick="jiesuan()">结算</a></div>
	</div>
	<div class="bottom"></div>
	<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#checkbox1").on("click",function(){
				if(this.checked==true){
					$("input").prop("checked",true);
				}else{
					$("input").prop("checked",false);
				}
			});
			var msg = "${message}";
			if(msg != ""){
				alert(msg);	
			}
		});
		function fun(){
			var check = document.getElementsByName("iid");
			var flag = false;
			if(check.length==0){
				alert("购物车没有物品可移除！");
			} else{
				for(var i = 0;i<check.length;i++){
					if(check[i].checked==true){
						flag = true;
						break;
					}
				}
				if(flag==false){
					alert("请选择要移除的商品！")
				}else{
					$("#form2").submit();
				}
			} 
		}
		function jiesuan(){
			var check = document.getElementsByName("iid");
			var flag = false;
			if(check.length==0){
				alert("购物车中没有物品可结算！");
			}else{
				for(var i = 0;i<check.length;i++){
					if(check[i].checked==true){
						flag = true;
						break;
					}
				}
				if(flag==false){
					alert("请选择要结算的商品！");
				}else{
					var rlu = "<c:url value='/jiesuan'></c:url>";
					$("#form2").attr("action",rlu);
					$("#form2").submit();
				}
			}
		}
	</script>
</body>
</html>