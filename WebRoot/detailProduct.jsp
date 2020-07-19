<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户查看某商品详情界面</title>
<style type="text/css">
#allProduct {
	margin: 0.5cm;
	border: 5px outset #0000FF;
	float: left;
	border-style: ridge;
}
</style>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("user") != null) {
		%>
		<div id="allProduct">
			<table border="1">
				<tr>
					<td rowspan="7"><img src="../images/${product.picture }" /></td>
					<td>商品ID:</td>
					<td>${product.productID }</td>
				</tr>
				<tr>
					<td>商品编号</td>
					<td>${product.serialNumber }</td>
				</tr>
				<tr>
					<td>商品名称:</td>
					<td>${product.name }</td>
				</tr>
				<tr>
					<td>商品品牌</td>
					<td>${product.brand }</td>
				</tr>
				<tr>
					<td>商品型号</td>
					<td>${product.model }</td>
				</tr>
				<tr>
					<td>商品价格</td>
					<td>${product.price }</td>
				</tr>
				<tr>
					<td>商品描述</td>
					<td>${product.description }</td>
				</tr>
			</table>
		</div>
		<%
			} else {
				response.setHeader("refresh", "2;URL = /company-ssm/mainPage.jsp");
		%>
		<h2>您还未登录，请先登录！</h2>
		<h3>2秒后将返回登陆页面</h3>
		<%
			}
		%>
	</div>
</body>
</html>