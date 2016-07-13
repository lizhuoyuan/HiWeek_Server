<%@page import="com.HiWeek.Bean.Action"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	ArrayList<Action> alist = (ArrayList<Action>) session
			.getAttribute("publishedA");
	Action action;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'PubedActivities.jsp' starting page</title>

</head>

<body>
	<div align="center">
		<%
			if (alist.size() == 0) {
		%>
		<h4>您还未发布任何活动</h4>
		<%
			} else {
		%>
		<table id="atable">
			<caption>已发布的活动</caption>
			<tr>
				<th>活动ID</th>
				<th>活动主题</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th colspan="2">操作</th>
			</tr>

			<%
				for (int i = 0; i < alist.size(); i++) {
						action = alist.get(i);
			%>
			<tr>
				<td><%=action.getA_id()%></td>
				<td><%=action.getA_itemname()%></td>
				<td><%=action.getA_stime()%></td>
				<td><%=action.getA_etime()%></td>
				<td><a href="servlet/ShowInfo?a_id=<%=action.getA_id()%>">查看详细信息</a></td>
				<td><a
					href="Merchant/UpdateAInfo.jsp?a_id=<%=action.getA_id()%>">修改</a></td>
			</tr>
			<%
				}
			%>

		</table>
		<%
			}
		%>
	</div>
</body>
</html>
