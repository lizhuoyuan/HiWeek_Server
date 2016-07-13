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

<title>My JSP 'ActivitiesMenu.jsp' starting page</title>
</head>

<body style="text-align:center">
<div align="center" style="padding:30%">
<a href="Merchant/PubActivity.jsp" target="ActivitiesRFrame">发布活动</a><br>
<a href="Merchant/UpdateAInfo.jsp" target="ActivitiesRFrame">修改活动信息</a><br>
 <a href="servlet/Apublished" target="ActivitiesRFrame">查看已发布活动</a><br>

	</div>
</body>
</html>
