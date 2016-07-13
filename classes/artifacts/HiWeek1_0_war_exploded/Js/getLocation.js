var proval = null;
var cityval = null;
var countryval = null;
$(document).ready(function(e) {
	var provence = $("#provence");
	var city = $("#city");
	var country = $("#country");
	provence.append("<option value='0'>---请选择省份---</option>");
	city.append("<option value='0'>---请选择市---</option>");
	country.append("<option value='0'>---请选择区/县---</option>");

	$.post("servlet/SelectServlet", {
		provence : proval,
		city : cityval,
		country : countryval,
	}, showProvence);
	provence.change(function(e) {
		proval = $(this).val();
		cityval = null;
		countryval = null;
		city.empty();
		country.empty();
		$("#result").hide();
		city.append("<option value='0'>---请选择市---</option>");
		getCity();
	});
	city.change(function(e) {
		countryval = null;
		cityval = $(this).val();
		country.empty();
		$("#result").hide();
		country.append("<option value='0'>---请选择区/县---</option>");
		getCountry();
	});
	country.change(function(e) {
		countryval = $(this).val();
		getInfo();
	});
});
function showProvence(data) {
	// alert(data);
	var list = $.parseJSON(data);
	for (var i = 0; i < list.length; i++) {
		$("#provence").append(
				"<option value='" + list[i] + "'>" + list[i] + "</option>");
	}
}
function getCity() {
	$.post("servlet/SelectServlet", {
		provence : proval,
		city : cityval,
		country : countryval,
	}, showCity);
}
function getCountry() {
	$.post("servlet/SelectServlet", {
		provence : proval,
		city : cityval,
		country : countryval,
	}, showCountry);
}
function showCity(data) {
	var list = $.parseJSON(data);
	for (var i = 0; i < list.length; i++) {
		$("#city").append(
				"<option value='" + list[i] + "'>" + list[i] + "</option>");
	}
}
function showCountry(data) {
	var list = $.parseJSON(data);
	for (var i = 0; i < list.length; i++) {
		$("#country").append(
				"<option value='" + list[i] + "'>" + list[i] + "</option>");
	}
}
function getInfo() {
	$.post("servlet/SelectServlet", {
		provence : proval,
		city : cityval,
		country : countryval,
	}, showInfo);
}
function showInfo(data) {
	$("#result").show();
	$("#result span").text(data);

}