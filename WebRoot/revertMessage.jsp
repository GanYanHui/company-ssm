<%@page import="jmu.gyh.po.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${message.title }</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("user") != null) {
				Person per = (Person) session.getAttribute("user");
		%>
		<h3>${message.title }</h3>
		<table border="2">
			<tr>
				<th>作者</th>
				<th>帖子内容</th>
				<th>留言时间</th>
			</tr>
			<tr>
				<td>${message.writer }</td>
				<td>${message.content }</td>
				<td>${message.writeDate }</td>
			</tr>
		</table>
		<h2>-----------------------------以下是回复-----------------------------</h2>
		<table border="2">
			<tr>
				<th>作者</th>
				<th>回复内容</th>
				<th>发言时间</th>
			</tr>
			<c:forEach items="${listRev }" var="rev">
				<tr>
					<td>${rev.writer }</td>
					<td>${rev.content }</td>
					<td>${rev.writeDate }</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<form action="${pageContext.request.contextPath }/user/insertRev.do"
			method="post">
			<h4>添加留言回复</h4>
			<input type="hidden" name="messageID" value=${message.messageID } />
			<input type="hidden" name="writer" value="<%=per.getName()%>" />
			<textarea name="content" rows="6" cols="50"></textarea>
			<br /> <input type="submit" value="回复" /> <input type="reset"
				value="重置" />
		</form>
		<h2>
			<a href="${pageContext.request.contextPath }/user/findAllPro.do">返回留言列表</a>
		</h2>
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