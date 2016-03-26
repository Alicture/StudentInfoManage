<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success!!</title>
</head>
<body>
	<%
		String userName = (String) session.getAttribute("username");
		String age = (String) session.getAttribute("age");
		String weight = (String) session.getAttribute("weight");
		String sex = (String) session.getAttribute("sex");
		System.out.println("性别：A" + sex + "A");
		if (sex.trim().equals("M"))
		{
			sex = "男";
		} else if(sex.trim().equals("F"))
		{
			sex = "女";
		}
		else{
			sex="未知";
		}
		
	%>
	<div align="center">
		<%=userName%>
		欢迎您，登陆成功！<br /> <font color="blue">登陆用户信息：</font>
		<table border=1>
			<tr>
				<td>姓名：</td>
				<td><%=userName%></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><%=age%></td>
			</tr>
			<tr>
				<td>体重：</td>
				<td><%=weight%> kg</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><%=sex%></td>
			</tr>
		</table>
		<a href="login.jsp">返回</a>
	</div>
</body>
</html>
