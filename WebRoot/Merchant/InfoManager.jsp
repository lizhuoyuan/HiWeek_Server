<%@page import="com.HiWeek.Bean.Merchant"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Merchant merchant = (Merchant) session.getAttribute("merchantInfo");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="cache-control" content="no-cache">
<script src="Js/jquery-2.1.4.js"></script>
<script src="Js/InfoManager.js"></script>
</head>
<body>
	<div align="center" id="showInfo">
		<h4>您的基本信息</h4>
		<table align="center" height="50%" id="info">
			<tr>
				<td>账户ID:</td>
				<td><%=merchant.getMer_id()%></td>
			</tr>
			<tr>
				<td>公司名称:</td>
				<td><%=merchant.getMer_name()%></td>
			</tr>
			<tr>
				<td>所在地址:</td>
				<td><%=merchant.getMer_address()%></td>
			</tr>
			<tr>
				<td>联系方式:</td>
				<td><%=merchant.getMer_tel()%></td>
			</tr>
			<tr>
				<td>公司描述：</td>
				<td><%=merchant.getMer_introduce()%></td>
			</tr>
			<tr>
				<td>公司类别：</td>
				<td><select>
						<option>1</option>

						<option>2</option>

						<option>3</option>
				</select></td>
			</tr>
		</table>
	</div>
	<div align="center">
		<button onclick="showInfo()" style="display: none;" id="show">查看信息</button>
		<button onclick="updateInfo()">完善信息</button>
		<button onclick="safe()">安全设置</button>
		<!-- ------------------------完善信息----------------------- -->
		<div align="center" id="updateInfo" style="display: none;">
			<form>
				<table align="center" height="50%" id="info">
					<tr style="display: none;">
						<td><input type="text" id="mer_id"
							value="<%=merchant.getMer_id()%>"></td>
					</tr>
					<tr>
						<td>账户ID:</td>
						<td><%=merchant.getMer_id()%></td>
					</tr>
					<tr>
						<td>公司名称:</td>
						<td><input type="text" id="mer_name"
							value="<%=merchant.getMer_name()%>"></td>
					</tr>
					<tr>
						<td>所在地址:</td>
						<td><input type="text" id="mer_address"
							value="<%=merchant.getMer_address()%>"></td>
					</tr>
					<tr>
						<td>联系方式:</td>
						<td><input type="text" id="mer_tel"
							value="<%=merchant.getMer_tel()%>"></td>
					</tr>
					<tr>
						<td>公司描述：</td>
						<td><input type="text" id="mer_introduce"
							value="<%=merchant.getMer_introduce()%>"></td>
					</tr>
					<tr>
						<td>公司类别：</td>
						<td><select id="type_id">
								<option value="1">1</option>

								<option value="2">2</option>

								<option value="3">3</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="reset" value="重置">
							<button onclick="submitInfo()">提交</button></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- ------------------------安全设置----------------------- -->

		<div id="safe" align="center" style="display: none;">
			<form>
				<table>
					<tr style="display: none;">
						<td><input type="text" id="id"
							value="<%=merchant.getMer_id()%>"></td>
					</tr>
					<tr style="display: none;">
						<td><input type="text" id="pwd"
							value="<%=merchant.getMer_password()%>"></td>
					</tr>
					<tr>
						<td>原密码：</td>
						<td><input type="password" id="oldpwd"></td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td><input type="password" id="newpwd"></td>
					</tr>
					<tr>
						<td>重复密码：</td>
						<td><input type="password" id="ensurepwd"></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="reset" value="重置">
							<button onclick="submitPwd()">提交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<br>
</body>
</html>
