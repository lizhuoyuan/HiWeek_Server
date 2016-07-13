<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	boolean flag = false;
	if (request.getSession().getAttribute("userlogin") != null) {
		flag = ((Boolean) request.getSession().getAttribute("userlogin")).booleanValue();
		
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>join</title>
<script type="text/javascript" src="Js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="Js/MerchantLogin.js"></script>
<style type="text/css">
.status1 {
	font: #CCC;
}

.status2 {
	font: #000;
}

#login_div {
	height: 250px;
	padding: 120px;
	line-height: 250px;
}
</style>
</head>

<body>
	<jsp:include page="HeadJsp.jsp"></jsp:include>
	<%
		if (!flag) {
	%>
	<div align="center" id="login_div">
		<table cellpadding="20px">
			<tr>
				<td>手机号：</td>
				<td><input type="text" id="tel" value="请输入注册时的手机号"
					onBlur="if(this.value==''){this.value='请输入注册时的手机号';this.className='status2';}"
					onFocus="if(this.value==this.defaultValue){this.value='';this.className='status1';}" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center" valign="middle"><button
						id="reset">重置</button>
					<button id="submit" onclick="submit()">提交</button></td>
			</tr>
		</table>
		<div>
			<a href="HomePage/register.jsp">注册</a>
		</div>
	</div>
	<%
		} else {
	%>
	<div align="center" style="height: 400px">
		已经登陆，无须再次登陆<br>进入<a href="Merchant/MainJsp.jsp">商户中心</a>
	</div>
	<%
		}
	%>
	<jsp:include page="FootJsp.jsp"></jsp:include>
</body>
</html>
