<%@page import="com.test.dao.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>学生信息</h1>
	</div>
	<div style="text-align: right">
		<a href="/LoginTest/index.jsp">返回首页</a>
	</div>
	<br><br><br>
		<table border="1" align="center">

			<tr>
				<td>id</td>
				<td>username</td>
				<td>userpsw</td>
				<td>age</td>
				<td>weight</td>
				<td>sex</td>
				<td colspan="2">操作</td>
			</tr>


			<c:forEach var="item" items="${list }">
				<tr>
					<td><c:out value="${item.id }" /></td>
					<td><c:out value="${item.username }" /></td>
					<td><c:out value="${item.userpsw }" /></td>
					<td><c:out value="${item.age }" /></td>
					<td><c:out value="${item.weight }kg" /></td>
					<td><c:out value="${item.sex }" /></td>
				<td><a href="/LoginTest/DeleteServlet?id=${item.id }">删除</a></td>
				<td><a href="/LoginTest/UpdateServlet?id=${item.id }">修改</a></td>
				</tr>
				
				


			</c:forEach>

		</table>


</body>
</html>