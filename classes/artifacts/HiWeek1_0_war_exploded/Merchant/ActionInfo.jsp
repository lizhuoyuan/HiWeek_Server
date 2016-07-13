<%@page import="com.HiWeek.Bean.Action"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Action action = (Action) session.getAttribute("Action");
	String photoPath = request.getContextPath() + "/ActionPhotos/"
			+ action.getMerchant().getMer_id() + "/"
			+ action.getA_photo();
			System.out.println(photoPath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ActionInfo.jsp' starting page</title>

</head>

<body>
	<div align="center">
		<table width="90%" height="90%" border="1" cellspacing="0">
			<caption>
				<h3>活动详细信息</h3>
			</caption>
			<tr align="center" height="20%">
				<td width="10%">主题名</td>
				<td width="20%"><%=action.getA_itemname()%></td>
				<td width="10%" rowspan="2">活动类别</td>
				<td width="10%" rowspan="2"><%=action.getType().getT_name()%></td>
				<td width="10%" colspan="2" rowspan="2">活动图片</td>
				<td rowspan="2"><img src="<%=photoPath%>"></td>
			</tr>
			<tr align="center" height="20%">
				<td>价格</td>
				<td><%=action.getA_price()%></td>
			</tr>
			<tr align="center" height="20%">
				<td>开始时间</td>
				<td><%=action.getA_stime()%></td>
				<td colspan="4" rowspan="2">地址</td>
				<td rowspan="2"><%=action.getA_address()%></td>
			</tr>
			<tr align="center" height="20%">
				<td>结束时间</td>
				<td><%=action.getA_etime()%></td>
			</tr>
			<tr align="center" height="10%">
				<td>活动介绍</td>
				<td colspan="6"><textarea id="a_introduce" rows="5"><%=action.getA_introduce()%></textarea>
				</td>
			</tr>
			<tr align="center" height="10%">
				<td>咨询方式</td>
				<td colspan="6"><textarea id="a_consult" rows="5"><%=action.getA_consult()%></textarea></td>
			</tr>
			<tr align="center" height="10%">
				<td>参加说明</td>
				<td colspan="6"><textarea id="a_joinex" rows="5"><%=action.getA_joinex()%></textarea></td>
			</tr>
			<tr align="center" height="10%">
				<td>FAQ</td>
				<td colspan="6"><textarea id="a_FAQ" rows="5"><%=action.getA_FAQ()%></textarea></td>
			</tr>
			<tr align="center" height="10%">
				<td>收费说明</td>
				<td colspan="6"><textarea id="a_charge" rows="5"><%=action.getA_charge()%></textarea></td>
			</tr>
			<tr>
				<td colspan="7" align="center"><button onclick="publishA()">发布</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
