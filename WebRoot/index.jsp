<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

<title>My JSP 'index.jsp' starting page</title>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link href="CSS/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="CSS/style.css" rel='stylesheet' type='text/css' />
<script src="JS/jquery-1.11.0.min.js"></script>
<!---- start-smooth-scrolling---->
<script type="text/javascript" src="JS/move-top.js"></script>
<script type="text/javascript" src="JS/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!---end-smooth-scrolling-->
<!--start-top-nav-script-->
<script>
	$(function() {
		var pull = $('#pull');
		menu = $('nav ul');
		menuHeight = menu.height();
		$(pull).on('click', function(e) {
			e.preventDefault();
			menu.slideToggle();
		});
		$(window).resize(function() {
			var w = $(window).width();
			if (w > 320 && menu.is(':hidden')) {
				menu.removeAttr('style');
			}
		});
	});
</script>
<!--End-top-nav-script-->
</head>
<body>
	<jsp:include page="HomePage/HeadJsp.jsp"></jsp:include>
	<!--start-banner-->
	<div class="banner">
		<div class="container">
			<div class="banner-top">
				<h2>-Welcome To-</h2>
				<h1>Hi weekend</h1>
			</div>
			<div class="banner-bottom">
				<div id="top" class="callbacks_container">
					<ul class="rslides" id="slider4">
						<li><img src="Images/banner-1.jpg" alt="" /></li>
						<li><img src="Images/banner-2.jpg" alt="" /></li>
						<li><img src="Images/banner-3.jpg" alt="" /></li>
						<li><img src="Images/banner-4.jpg" alt="" /></li>
						<li><img src="Images/banner-5.jpg" alt="" /></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--End-banner-->
	<!--Slider-Starts-Here-->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : true,
				nav : true,
				speed : 500,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>
	<!--End-slider-script-->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">企业网站模板</a>
	</div>
	<jsp:include page="HomePage/FootJsp.jsp"></jsp:include>

</body>

</html>
