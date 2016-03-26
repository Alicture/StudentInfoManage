<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="/LoginTest/RegisterServlet" method="post" >
	用户名：<input type="text" name="username"><br>
	密码：<input type="text" name="password"><br>
	性别： <input type="radio" name="M" value="sex">男
			<input type="radio" name="F" value="sex">女<br>
	年龄：<input type="text" name="age"><br>
	体重：<input type="text" name="weight"><br>

<input type="submit" value="注册"> 
<a href="index.jsp">返回</a><br>

<a href="/LoginTest/ShowUserinfoServlet">查看数据</a>
</form>
</div>

</body>
</html>