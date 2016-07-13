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
<style type="text/css">
/*div背景黑色*/
div#home {
	background-color: #000
}
/*li横向显示*/
ul#link li {
	display: inline;
}
/*居右显示*/
nav ul#link {
	text-align: right;
	margin-right: 20px
}
/*字体白色*/
ul#link li a {
	color: #CCC
}
</style>
<title>HomePage</title>
</head>

<body>
	<div class="header" id="home">
		<a href="index.jsp"> <img src="Images/LOGO.png" height="50"></a>
		<nav>
		<ul id="link">
			<li><a href="index.jsp" class="active">主页</a></li>&nbsp;/
			<li><a href="HomePage/about-us.jsp">关于</a></li>&nbsp;/
			<li><a href="HomePage/services.jsp">服务</a></li>&nbsp;/
			<li><a href="HomePage/clients.jsp">商家展示</a></li>&nbsp;/
			<li><a href="HomePage/join.jsp">商户入驻</a></li>&nbsp;/
			<li><a href="HomePage/contact.jsp">联系我们</a></li>
		</ul>
		</nav>
	</div>

</body>
</html>
