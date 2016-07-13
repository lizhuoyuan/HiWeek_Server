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

<title>My JSP 'Admin.jsp' starting page</title>
<script type="text/javascript" src="Js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	function resetMovie() {
		alert("时机未到");
		//$.post("servlet/Admin/UpdateMovieData", {}, result);

	}
	function resetCinema() {
		$.post("servlet/Admin/UpdateCinemaData", {}, result);

	}
	function result(data) {
		alert(data);
	}
</script>
</head>

<body>
	<div align="center" style="padding: 200px;">
		<button onclick="resetMovie()">更新电影信息</button>
		<button onclick="resetCinema()">更新影院信息</button>
	</div>
</body>
</html>
