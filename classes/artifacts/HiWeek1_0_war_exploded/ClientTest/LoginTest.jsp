<%@page import="com.google.gson.Gson"%>
<%@page import="com.HiWeek.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
     User user = new User("xujichang", "123456", "1234567890");
			Gson gson = new Gson();
			String jsonString = gson.toJson(user);
			System.out.println("数据长度：" + jsonString.length()); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../Js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	function submit(data) {
		alert(data);
		$.post("../servlet/client/UserRegister",{
			UserInfo:{"u_id":0,"u_name":"xujichang","u_pwd":"123456","u_tel":"1234567890","u_credit":0}
		},callback)
	}
	function callback(data) {
		alert(data);
	}
</script>
</head>
<body>
	<button onclick="submit()">注册</button>
</body>
</html>