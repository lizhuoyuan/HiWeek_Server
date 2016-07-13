// JavaScript Document
function submit() {
	var telstr = $("#tel");
	var pwdstr = $("#pwd");
	$.post("servlet/MerchantLogin", {
		tel : telstr.val(),
		pwd : pwdstr.val(),
	}, logincallback);
}
function logincallback(data) {
	if (data == 1) {
		alert("登陆成功");
		window.location = "Merchant/MainJsp.jsp";
	} else {
		alert("登录失败");

	}

}
function register() {
	var name = $("#name").val();
	var tel = $("#tel").val();
	var pwd = $("#pwd").val();
	var type = $("#type").val();
	$.get("servlet/MerRegister", {
		mer_name : name,
		mer_tel : tel,
		mer_pwd : pwd,
		t_id : type
	}, back);
}
function back(data) {
	if (data == 1) {
		alert("注册成功");
	} else {
		alert("注册失败");
	}
}