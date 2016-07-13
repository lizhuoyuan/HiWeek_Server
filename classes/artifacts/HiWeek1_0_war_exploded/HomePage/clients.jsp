<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'clients.jsp' starting page</title>
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
  
  <body> <jsp:include page="HeadJsp.jsp"></jsp:include>
    This is my clientsJSP page. <br>
	<jsp:include page="FootJsp.jsp"></jsp:include>
</body>
</html>
