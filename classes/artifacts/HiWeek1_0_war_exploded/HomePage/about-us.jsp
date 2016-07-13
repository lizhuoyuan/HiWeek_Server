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

<title>My JSP 'about-us.jsp' starting page</title>
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
	<jsp:include page="HeadJsp.jsp"></jsp:include>
	<!--start-about-->
	<div class="about">
		<div class="container">
			<div class="about-main">
				<h3>About Us</h3>
				<div class="about-top">
					<div class="col-md-5 about-top-left">
						<img src="Images/abt-1.jpg" alt="">
					</div>
					<div class="col-md-7 about-top-right">
						<h4>Duis autem vel eum iriure dolor in hendrerit in vulputate
							velit esse molestie consequat.</h4>
						<p>Fusce feugiat malesuada odio orbi nunc odio gravida at
							cursus nec luctus a lorem. Maecenas tristique orci ac sem. Duis
							ultricies pharetra magna onec accumsan malesuada orci. Donec sit
							amet eros. Lorem ipsum dolor sit amet, consectetuer adipiscing
							elit. Mauris fermentum dictum magna. Sed laoreet aliquam leo.Ut
							tellus dolor, dapibus eget, elementum vel, cursus eleifend.</p>
						<p>Bulum iaculis lacinia est. Proin dictum elemntum velit.
							Fusce euismod cons equat ante. Lorem ipsum dmeconsectetuer
							adipiscing elit. ellentesque sed dolor. Aliquam congue fermentum
							nisl. Mauris accumsan nulla vel diam. Sed in lacus ut enim
							adipiscing aliquet. Nulla vene natis. In pede mi aliquet sit amet
							euismod in auctor ut ligula.</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--End-about-->
	<!--start-team-->
	<div class="team">
		<div class="container">
			<div class="team-top">
				<h3>Our Team</h3>
			</div>
			<ul class="ch-grid">
				<li>
					<div class="ch-item ch-img-1">
						<div class="ch-info">
							<h3>Brainiac</h3>
							<p>
								by Daniel Nyari <a href="#">View on Dribbble</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="ch-item ch-img-2">
						<div class="ch-info">
							<h3>Vision</h3>
							<p>
								by Daniel Nyari <a href="#">View on Dribbble</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="ch-item ch-img-3">
						<div class="ch-info">
							<h3>Cylon</h3>
							<p>
								by Daniel Nyari <a href="#">View on Dribbble</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="ch-item ch-img-4">
						<div class="ch-info">
							<h3>Tom Lopes</h3>
							<p>
								by Daniel Nyari <a href="#">View on Dribbble</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="ch-item ch-img-5">
						<div class="ch-info">
							<h3>Sam Lee</h3>
							<p>
								by Daniel Nyari <a href="#">View on Dribbble</a>
							</p>
						</div>
					</div>
				</li>
				<li>
					<div class="ch-item ch-img-6">
						<div class="ch-info">
							<h3>Alan Smith</h3>
							<p>
								by Daniel Nyari <a href="#">View on Dribbble</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<!--end-team-->
	<jsp:include page="FootJsp.jsp"></jsp:include>
</body>
</html>
