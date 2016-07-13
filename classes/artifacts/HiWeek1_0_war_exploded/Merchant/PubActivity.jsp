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

<title>My JSP 'PubActivity.jsp' starting page</title>
<script type="text/javascript" src="Js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="Js/getLocation.js"></script>
<script type="text/javascript" src="Js/publishA.js"></script>

<style>
textarea {
	width: 80%;
}
</style>
</head>

<body>
	<div align="center">
		<table width="90%" height="90%" border="1" cellspacing="0">
			<caption>
				<h3>发布活动</h3>
			</caption>
			<tr align="center" height="20%">
				<td width="10%">主题名</td>
				<td width="20%"><input type="text" id="a_itemname" /></td>
				<td width="10%" rowspan="2">活动类别</td>
				<td width="10%" rowspan="2">
                <select id ="Atype">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                 </select>
                </td>
				<td width="10%" colspan="2" rowspan="2">活动图片</td>
				<td rowspan="2">
					<form action="servlet/AImageServlet" id="image_form" enctype="multipart/form-data"
						method="post">
						<input type="file" name="a_photo" />
					</form>
				</td>
			</tr>
			<tr align="center" height="20%">
				<td>价格</td>
				<td><input type="text" id="a_price" /></td>
			</tr>
			<tr align="center" height="20%">
				<td>开始时间</td>
				<td><p>注意格式：年-月-日</p><input type="text" id="a_stime" /></td>
				<td colspan="4" rowspan="2">地址</td>
				<td rowspan="2">
					<div align="center">
						<select id="provence"></select> <select id="city"></select> <select
							id="country"></select>
					</div>
					<div id="result" style="display:none">
						<span></span><br>
						<p>请继续填写详细地址：</p>
						<input type="text" id="lInfo">
					</div>
				</td>
			</tr>
			<tr align="center" height="20%">
				<td>结束时间</td>
				<td><p>注意格式：年-月-日</p><input type="text" id="a_etime" /></td>
			</tr>
			<tr align="center" height="10%">
				<td>活动介绍</td>
				<td colspan="6"><textarea id="a_introduce" rows="5"></textarea>
				</td>
			</tr>
			<tr align="center" height="10%">
				<td>咨询方式</td>
				<td colspan="6"><textarea id="a_consult" rows="5"></textarea></td>
			</tr>
			<tr align="center" height="10%">
				<td>参加说明</td>
				<td colspan="6"><textarea id="a_joinex" rows="5"></textarea></td>
			</tr>
			<tr align="center" height="10%">
				<td>FAQ</td>
				<td colspan="6"><textarea id="a_FAQ" rows="5"></textarea></td>
			</tr>
			<tr align="center" height="10%">
				<td>收费说明</td>
				<td colspan="6"><textarea id="a_charge" rows="5"></textarea></td>
			</tr>
			<tr><td colspan="7" align="center"><button onclick="publishA()">发布</button> </td></tr>
		</table>
	</div>
</body>
</html>
