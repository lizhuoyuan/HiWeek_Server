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
		<table width="100%">
			<tr>
				<td><img src="Images/LOGO.png" height="100px"></td>
				<td align="right"><nav>
					<ul id="link">
						<li><a href="Merchant/MerchantCenter.jsp"
							target="MerchantCenterFrame">商家中心</a></li>&nbsp;/
						<li><a href="servlet/InfoManager"
							target="MerchantCenterFrame">信息管理</a></li>&nbsp;/
						<li><a href="Merchant/Activities.jsp"
							target="MerchantCenterFrame">活动管理</a></li>&nbsp;/
						<li><a href="Merchant/FeedBack.jsp"
							target="MerchantCenterFrame">用户反馈</a></li>&nbsp;/
						<li><a href="Merchant/AboutUs.jsp"
							target="MerchantCenterFrame">关于</a></li>&nbsp;/
						<li><a href="Merchant/ConnectUs.jsp"
							target="MerchantCenterFrame">联系我们</a></li>
					</ul>
					</nav></td>
			</tr>

		</table>
		<div align="right" style="background-color:#666">
			<%
				if (session.getAttribute("userlogin") != null) {
			%>当前登录账户:${sessionScope.user}
			<%
				}
			%>
			<a href="servlet/MerchantLoginOff" style="font: #FFF">注销</a>
		</div>
	</div>
	<div align="left" style="background-color:#666">
		当前位置&rArr;<a href="#" style="font: #FFF">商户中心</a>
	</div>
</body>
</html>
