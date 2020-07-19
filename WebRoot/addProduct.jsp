<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("user") != null) {
		%>
		<h2>新增商品</h2>
		<hr>
		<form action="${pageContext.request.contextPath }/admin/insertPro.do"
			method="post">
			<table>
				<tr>
					<td>商品编号:<input type="text" name="serialNumber" /></td>
				</tr>
				<tr>
					<td>商品名称:<input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>商品品牌<input type="text" name="brand" /></td>
				</tr>
				<tr>
					<td>商品型号<input type="text" name="model" /></td>
				</tr>
				<tr>
					<td>商品价格<input type="text" name="price" /></td>
				</tr>
				<tr>
					<td>商品图片<input type="text" name="picture" /></td>
				</tr>
				<tr>
					<td>商品描述<textarea name="description" cols="25" rows="5"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="添加" /> <input
						type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath }/user/findAllPro.do">返回商品列表</a>
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