<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<form method="POST" name="frmLogin" action="LoginTestServlet">
		<h1 align="center">用户登录</h1>
		<center>
			<table border="1">
			
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username" value="" size="20"
						maxlength="20"
						onfocus="if (this.value=='Your name')  this.value='';" /></td>
						
				</tr>
				<tr>
					<td>密 码</td>
					<td><input type="password" name="password" value="" size="20"
						maxlength="20"
						onfocus="if(this.value=='Your Password') this.value='';">
					</td>
					
				</tr>
				<tr>
					<td><input type="submit" name="Submit" value=" 提交"
						onclick="return validateLogin()"></td>
					<td><input type="reset" name="Reset" value="重置" /></td>
				</tr>
			</table>
		</center>
	</form>
	<a href="/LoginTest/index.jsp">返回</a>

	<script type="text/javascript">
		function validateLogin() {
			var sUserName = document.frmLogin.username.value;
			var sPassword = document.frmLogin.psssword.value;
			if (sUserName == "") {
				alert("请输入用户名!");
				return false;
			}

			if (sPassword == "") {
				alert("请输入密码!");
				return false;
			}
		}
	</script>
</body>
</html>
