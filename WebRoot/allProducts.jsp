<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户浏览所有商品界面</title>
<style type="text/css">
#allProduct {
	margin: 0.5cm;
	border: 5px outset #0000FF;
	float: left;
	text-align: center;
	border-style: ridge;
}

#message {
	margin: 0.5cm;
	float: left;
}
</style>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("user") != null) {
		%>
		<h2>所有商品信息</h2>
		<c:forEach items="${listPro }" var="pro">
			<div id="allProduct">
				<table border="1">
					<tr>
						<td rowspan="5"><img src="../images/${pro.picture }" /></td>
						<td>商品编号:</td>
						<td>${pro.serialNumber }</td>
					</tr>
					<tr>
						<td>商品名称:</td>
						<td><a
							href="${pageContext.request.contextPath }/user/findProByProductID.do?productID=${pro.productID}">${pro.name }</a></td>
					</tr>
					<tr>
						<td>商品品牌</td>
						<td>${pro.brand }</td>
					</tr>
					<tr>
						<td>商品型号</td>
						<td>${pro.model }</td>
					</tr>
					<tr>
						<td>商品价格</td>
						<td>${pro.price }</td>
					</tr>
				</table>
			</div>
		</c:forEach>
		<div id="message">
			<hr>
			<h2>留言板</h2>
			<table border="2">
				<tr>
					<th>留言ID</th>
					<th>标题</th>
					<th>内容</th>
					<th>作者</th>
					<th>发表时间</th>
					<th>回复数</th>
				</tr>
				<c:forEach items="${listMes }" var="mes">
					<tr>
						<td>${mes.messageID }</td>
						<td>${mes.title }</td>
						<td><a
							href="${pageContext.request.contextPath }/user/findRevByMesID.do?messageID=${mes.messageID}">${mes.content }</a></td>
						<td>${mes.writer }</td>
						<td>${mes.writeDate }</td>
						<td>${mes.count }</td>

					</tr>
				</c:forEach>
			</table>
			<a href="/company-ssm/newMessage.jsp">添加新留言</a>
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