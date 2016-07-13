// JavaScript Document
$(document).ready(function(e) {
   $.post("servlet/InfoManager",null,null);
});
function updateInfo(){
	$("#showInfo").hide(500);
	$("#safe").hide(500);
	$("#show").show(500);
	$("#updateInfo").show(500);
}
function safe(){
	$("#updateInfo").hide(500);
	$("#showInfo").hide(500);
	$("#safe").show(500);

}
function showInfo(){
	$("#show").hide(500);
	$("#updateInfo").hide(500);
	$("#safe").hide(500);
	$("#showInfo").show(500);
	}
function submitInfo(){
	//对提交数据进行检验
	
	
	
	$.post("servlet/UpdateInfo",{
		mer_id:$("#mer_id").val(),
		mer_name:$("#mer_name").val(),
		mer_address:$("#mer_address").val(),
		mer_tel:$("#mer_tel").val(),
		mer_introduce:$("#mer_introduce").val(),
		type_id:$("#type_id").val()
		},result);
	}
function result(data){
alert(data);
	$.post("servlet/InfoManager",null,null);
}
function submitPwd(){
	var old = $("#oldpwd").val();
	var newpwd = $("#newpwd").val();
	var ensure = $("#ensurepw").val();
	var id = $("#id").val();
	//添加对密码的检验
	
	
	$.post("servlet/ChangePwd",{
		mer_id:id,
		pwd :newpwd},pwdresult);
}
function pwdresult(data){
	alert(data);
}