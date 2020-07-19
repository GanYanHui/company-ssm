<%@page import="jmu.gyh.po.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增留言页</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("admin") != null) {
				Person per = (Person)session.getAttribute("admin");
		%>
		<h2>发布新留言</h2>
		<form action="${pageContext.request.contextPath }/admin/insertMes.do" method="post">
			标题:<input type="text" name="title" /><br />
			内容:<input type="text" name="content" /><br /> 
			<input type = "hidden" name = "writer" value = "<%=per.getName() %>" />
			<input type="submit" value="添加" /><input type="reset" value="重置" />
		</form>
		<br /> 	
		<a href="${pageContext.request.contextPath }/admin/findAllPro.do">返回留言列表</a>
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