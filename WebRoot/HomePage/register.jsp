<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>
<script type="text/javascript" src="Js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="Js/MerchantLogin.js"></script>
</head>

<body>
	<jsp:include page="HeadJsp.jsp"></jsp:include>

	<div align="center" style="padding: 100px">
		<form>
			<table>
				<caption>注册</caption>
				<tr>
					<td>公司名称：</td>
					<td><input type="text" id="name"></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" id="tel"></td>
				</tr>
				<tr>
					<td>账户密码：</td>
					<td><input type="password" id="pwd"></td>
				</tr>
				<tr>
					<td>公司类别：</td>
					<td><select id="type">
							<option value="4">长知识</option>
							<option value="4">长知识</option>
							<option value="4">长知识</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="reset" value="重置"></td>
					<td><button onclick="register()">提交</button></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="FootJsp.jsp"></jsp:include>

</body>
</html>
