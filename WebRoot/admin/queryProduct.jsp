<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品</title>
</head>
<body>
	<div align="center">
		<%
			if (request.getAttribute("admin") != null) {
				session.setAttribute("admin", request.getAttribute("admin"));
		%>
		<h2>
			欢迎管理员:<font color="red">${admin.name }</font>光临
		</h2>
		<h2>按ID查询商品</h2>
		<form
			action="${pageContext.request.contextPath }/admin/findProByProductID.do"
			method="post">
			商品ID:<input type="text" name="productID" /> <input type="submit"
				value="查询" />
		</form>
		<h2>
			<a href="${pageContext.request.contextPath }/admin/findAllPro.do">查询所有商品</a>
		</h2>
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