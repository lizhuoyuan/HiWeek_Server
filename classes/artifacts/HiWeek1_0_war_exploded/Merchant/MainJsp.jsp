<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Merchant Center</title>

  </head>
  
  <body>
   <jsp:include page="MerchantHead.jsp"/>
  <div>
  <iframe name="MerchantCenterFrame" width="100%" height="100%" src="Merchant/Activities.jsp">
  </iframe> 
  </div>
   <jsp:include page="MerchantFoot.jsp"/>
  </body>
</html>
