<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Acivities.jsp' starting page</title>

  </head>
 <frameset cols="30%,*">
<frame src="Merchant/ActivitiesMenu.jsp" name="ActivitiesLFrame"></frame>
<frame src="Merchant/ActivitiesDefault.jsp" name="ActivitiesRFrame"></frame>
 </frameset><noframes></noframes>
</html>
