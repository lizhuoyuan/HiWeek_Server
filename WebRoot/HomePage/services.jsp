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

<title>My JSP 'services.jsp' starting page</title>
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<link href="CSS/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="CSS/style.css" rel='stylesheet' type='text/css' />
<script src="JS/jquery-2.1.4.js"></script>
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
	<jsp:include page="HeadJsp.jsp"></jsp:include>
	<!--start-services-->
	<div class="services">
		<div class="container">
			<div class="services-main">
				<h3>Services We Provide</h3>
				<div class="services-top">
					<div class="col-md-6 services-top-left">
						<img src="Images/abt-1.jpg" alt="">
					</div>
					<div class="col-md-6 services-top-right">
						<h4>Aenean auctor wisi et urna. Aliquam erat volutpat.
							Integer rutrum ante eu lacus orbi nunc odio.</h4>
						<p>Ut tellus dolor, dapibus eget, elementum vel, cursus
							eleifend, elit. Aenean auctor wisi et urna. Aliquam erat
							volutpat. Duis ac turpis. Integer rutrum ante eu lacus orbi nunc
							odio, gravida at, cursus nec, luctus a, lorem. Maecenas tristique
							orci ac sem. Duis ultricies pharetra magna. Donec accumsan
							malesuada orci. Donec sit amet eros. Lorem ipsum dolor sit amet,
							consectetuer adipiscing elit.</p>
						<ul>
							<li><a href="#">Duis sit amet congue eros</a></li>
							<li><a href="#">Aliquam erat volutpat</a></li>
							<li><a href="#">Gratuitous octopus niacin</a></li>
							<li><a href="#">Defacto lingo est igpay</a></li>
							<li><a href="#">Sic tempus fugit esperanto</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--End-services-->
	<!--start-add-->
	<div class="additional">
		<div class="container">
			<div class="add-mian">
				<h3>Additional Services</h3>
				<div class="add-top">
					<div class="col-md-4 add-top-left">
						<div class="add-left">
							<img src="Images/add-1.png" alt="">
						</div>
						<div class="add-right">
							<h4>Lorem ipsum dolor sit</h4>
							<p>Donec volutpat dolor ut nibh laoreet , tincidunt lacus
								consequat. Nunc urna lacus, tristique quis ipsum in, pulvinar
								rutrum lacus.Nullam sollicitudin urna sed malesuada posuere.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 add-top-left">
						<div class="add-left">
							<img src="Images/add-2.png" alt="">
						</div>
						<div class="add-right">
							<h4>Aliquam risus nis</h4>
							<p>Donec volutpat dolor ut nibh laoreet , tincidunt lacus
								consequat. Nunc urna lacus, tristique quis ipsum in, pulvinar
								rutrum lacus.Nullam sollicitudin urna sed malesuada posuere.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 add-top-left">
						<div class="add-left">
							<img src="Images/add-3.png" alt="">
						</div>
						<div class="add-right">
							<h4>Morbi volutpat auctor</h4>
							<p>Donec volutpat dolor ut nibh laoreet , tincidunt lacus
								consequat. Nunc urna lacus, tristique quis ipsum in, pulvinar
								rutrum lacus.Nullam sollicitudin urna sed malesuada posuere.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="add-top">
					<div class="col-md-4 add-top-left">
						<div class="add-left">
							<img src="Images/add-4.png" alt="">
						</div>
						<div class="add-right">
							<h4>Lorem ipsum dolor sit</h4>
							<p>Donec volutpat dolor ut nibh laoreet , tincidunt lacus
								consequat. Nunc urna lacus, tristique quis ipsum in, pulvinar
								rutrum lacus.Nullam sollicitudin urna sed malesuada posuere.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 add-top-left">
						<div class="add-left">
							<img src="Images/add-5.png" alt="">
						</div>
						<div class="add-right">
							<h4>Aliquam risus nis</h4>
							<p>Donec volutpat dolor ut nibh laoreet , tincidunt lacus
								consequat. Nunc urna lacus, tristique quis ipsum in, pulvinar
								rutrum lacus.Nullam sollicitudin urna sed malesuada posuere.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 add-top-left">
						<div class="add-left">
							<img src="Images/add-6.png" alt="">
						</div>
						<div class="add-right">
							<h4>Morbi volutpat auctor</h4>
							<p>Donec volutpat dolor ut nibh laoreet , tincidunt lacus
								consequat. Nunc urna lacus, tristique quis ipsum in, pulvinar
								rutrum lacus.Nullam sollicitudin urna sed malesuada posuere.</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--End-add-->
	<jsp:include page="FootJsp.jsp"></jsp:include>
</body>
</html>
