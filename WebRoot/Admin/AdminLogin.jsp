<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	boolean error = false;
	if (request.getParameter("error") != null
			&& request.getParameter("error").equals("1")) {
		error = true;
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'AdminLogin.jsp' starting page</title>
</head>

<body>
	<div align="center" style="padding: 200px;">
		<form action="servlet/AdminLogin" method="get">
			<table>
				<caption>管理员登录</caption>
				<%
					if (error) {
				%>
				<tr>
					<td colspan="2">登录失败</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td>管理员账户</td>
					<td><input type="text" name="adminName"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="adminPwd"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" value="登录"></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>
