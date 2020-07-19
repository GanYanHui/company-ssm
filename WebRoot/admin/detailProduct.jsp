<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详细信息页面</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("admin") != null) {
		%>
		<h2>商品详细信息</h2>
		<hr>
		<table border="1">
			<tr>
				<th>商品ID</th>
				<th>编号</th>
				<th>名称</th>
				<th>品牌</th>
				<th>型号</th>
				<th>价格</th>
				<th>图片</th>
				<th>描述</th>
				<th>修改</th>
			</tr>

			<tr>
				<td>${product.productID }</td>
				<td>${product.serialNumber }</td>
				<td>${product.name }</td>
				<td>${product.brand }</td>
				<td>${product.model }</td>
				<td>${product.price }</td>
				<td>${product.picture }</td>
				<td>${product.description }</td>
				<td><a
					href="${pageContext.request.contextPath }/admin/findBeforeUpdate.do?productID=${product.productID}">修改</a></td>
			</tr>
		</table>
		<%
			} else {
				response.setHeader("refresh", "2;URL = /company-ssm/admin.jsp");
		%>
		<h2>您还未登录，请先登录！</h2>
		<h3>2秒后将返回登陆页面</h3>
		<%
			}
		%>
	</div>
</body>
</html>