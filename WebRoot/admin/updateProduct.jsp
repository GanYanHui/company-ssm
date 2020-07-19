<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("admin") != null) {
		%>
		<h2>修改商品信息</h2>
		<hr>
		<form action="${pageContext.request.contextPath }/admin/updatePro.do"
			method="post">
			<table>
				<tr>
					<td>商品ID: ${product.productID }<input type="hidden"
						name="productID" value="${product.productID }" /></td>
				</tr>
				<tr>
					<td>商品编号:<input type="text" name="serialNumber"
						value="${product.serialNumber }" /></td>
				</tr>
				<tr>
					<td>商品名称:<input type="text" name="name"
						value="${product.name }" /></td>
				</tr>
				<tr>
					<td>商品品牌<input type="text" name="brand"
						value="${product.brand }" /></td>
				</tr>
				<tr>
					<td>商品型号<input type="text" name="model"
						value="${product.model }" /></td>
				</tr>
				<tr>
					<td>商品价格<input type="text" name="price"
						value="${product.price }" /></td>
				</tr>
				<tr>
					<td>商品图片<input type="text" name="picture"
						value="${product.picture }" /></td>
				</tr>
				<tr>
					<td>商品描述<textarea name="description" cols="25" rows="5">${product.description }</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="修改" /> <input
						type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath }/admin/findAllPro.do">返回商品列表</a>
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