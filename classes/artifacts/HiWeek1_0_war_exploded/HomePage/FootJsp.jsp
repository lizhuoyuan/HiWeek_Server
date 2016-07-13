<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>FootJsp.jsp</title>
<style type="text/css">
/*div背景黑色*/
div#foot{background-color:#AAA}
/*li横向显示*/
ul#footlink li{display:inline;}
/*居右显示*/
nav ul#footlink{text-align:right;margin-right:20px}
/*字体白色*/
ul#footlink li a{color:#222}
</style>
  </head>
  
  <body>
  
  		<div id="foot">
			<nav >
            		<ul id="footlink">
						<li><a href="index.jsp" class="active">主页</a></li>&nbsp;/
									<li><a href="HomePage/about-us.jsp">关于</a></li>&nbsp;/
									<li><a href="HomePage/services.jsp">服务</a></li>&nbsp;/
									<li><a href="HomePage/clients.jsp">商家展示</a></li>&nbsp;/
									
									<li><a href="HomePage/contact.jsp">联系我们</a></li>
					</ul>
	</ul>
    </div>
  </body>
</html>
