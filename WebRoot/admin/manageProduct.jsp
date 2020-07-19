<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理所有商品界面</title>
</head>
<body>
	<div align="center">
		<%
			if (session.getAttribute("admin") != null) {
		%>
		<h2>所有商品信息</h2>
		<form
			action="${pageContext.request.contextPath }/admin/findProByLike.do">
			请输入查询内容:<input type="text" name="string"> <input
				type="submit" value="查询">
		</form>
		<table border="1">
			<tr>
				<th>商品ID</th>
				<th>编号</th>
				<th>名称</th>
				<th>品牌</th>
				<th>型号</th>
				<th>价格</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${listPro }" var="pro">
				<tr>
					<td>${pro.productID }</td>
					<td>${pro.serialNumber }</td>
					<td><a
						href="${pageContext.request.contextPath }/admin/findProByProductID.do?productID=${pro.productID}">${pro.name }</a></td>
					<td>${pro.brand }</td>
					<td>${pro.model }</td>
					<td>${pro.price }</td>
					<td><a
						href="${pageContext.request.contextPath }/admin/findBeforeUpdate.do?productID=${pro.productID}">修改</a></td>
					<td><a
						href="${pageContext.request.contextPath }/admin/deletePro.do?productID=${pro.productID}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h2>
			<a href="addProduct.jsp">新增商品</a> <a
				href="${pageContext.request.contextPath }/admin/findAllPro.do">查询所有</a>
		</h2>
		<hr>
		<h2>留言板</h2>
		<form
			action="${pageContext.request.contextPath }/admin/findMesByLike.do">
			请输入查询内容:<input type="text" name="string"> <input
				type="submit" value="查询">
		</form>
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
						href="${pageContext.request.contextPath }/admin/findRevByMesID.do?messageID=${mes.messageID}">${mes.content }</a></td>
					<td>${mes.writer }</td>
					<td>${mes.writeDate }</td>
					<td>${mes.count }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="newMessage.jsp">添加新留言</a>
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