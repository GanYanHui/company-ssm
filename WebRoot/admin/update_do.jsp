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
		<h2>修改商品信息</h2>
		<%
			if (session.getAttribute("admin") != null) {
		%>
		<%
			response.setHeader("refresh", "2;URL=findAllPro.do");
				boolean b = ((Boolean) request.getAttribute("flag")).booleanValue();
				if (b) {
		%>
		商品信息修改成功，两秒后跳转到商品列表页！！！ <br /> 如果没有跳转，请按 <a
			href="${pageContext.request.contextPath }/admin/findAllPro.do">这里
		</a>！！！
		<%
			} else {
		%>
		商品信息修改失败，两秒后跳转到商品列表页！！！ <br /> 如果没有跳转，请按 <a
			href="${pageContext.request.contextPath }/admin/findAllPro.do">这里
		</a>！！！
		<%
			}
		%>
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