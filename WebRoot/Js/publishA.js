/**
 * 
 */
function publishA() {
	// a_itemname a_price a_stime provence city country lInfo a_etime
	// a_introduce a_consult a_joinex a_FAQ a_charge
	var provence = $("#provence").val();
	var city = $("#city").val();
	var country = $("#country").val();
	var lInfo = $("#lInfo").val();

	var itemname = $("#a_itemname").val();
	var price = $("#a_price").val();
	var stime = $("#a_stime").val();
	var etime = $("#a_etime").val();
	var introduce = $("#a_introduce").val();
	var consult = $("#a_consult").val();
	var joinex = $("#a_joinex").val();
	var FAQ = $("#a_FAQ").val();
	var charge = $("#a_charge").val();
	var id = $("#Atype").val();
	// 添加对数据的判断

	// 将地址整合
	var location = provence + city + country + lInfo;
	$.post("servlet/PublishActivity", {
		a_itemname : itemname,
		a_price : price,
		a_stime : stime,
		a_etime : etime,
		a_introduce : introduce,
		a_consult : consult,
		a_joinex : joinex,
		a_FAQ : FAQ,
		a_charge : charge,
		t_id : id,
		a_address : location
	}, callback);

}
function callback(data){
	alert(data);
	if(data==1){
		uploadImage();
	}
	else{
		alert("发布失败");
	}
}
function uploadImage(){
	$("#image_form").submit();
}