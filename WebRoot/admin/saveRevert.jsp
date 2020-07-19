<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存留言回复</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("admin") != null) {
				int messageID = (int) request.getAttribute("messageID");
		%>
		<%
			boolean b = ((Boolean) request.getAttribute("flag")).booleanValue();
				if (b) {
		%>
		<h2>新增回复</h2>
		回复添加成功，两秒后跳转到留言列表页！！！ <br /> 如果没有跳转，请按 <a
			href="${pageContext.request.contextPath }/admin/findRevByMesID.do?messageID=<%=messageID %>">这里
		</a>！！！
		<%
			} else {
		%>
		回复添加失败，两秒后跳转到留言列表页！！！ <br /> 如果没有跳转，请按 <a
			href="${pageContext.request.contextPath }/admin/findRevByMesID.do?messageID=<%=messageID %>">这里
		</a>！！！
		<%
			}
				response.setHeader("refresh", "2;URL=findRevByMesID.do?messageID=" + messageID);
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