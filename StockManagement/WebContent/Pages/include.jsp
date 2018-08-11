<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="apple-touch-icon" href="apple-touch-icon.png">
 <link rel="stylesheet" href="<c:url value="/resources/css/normalize.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/owl.carousel.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/responsive.css" />">
 <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
		<div id="loader-wrapper">
            <div class="logo"></div>
            <div id="loader">
            </div>
        </div>
<!-- Start Header Section -->
<header class="main_menu_sec navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-12">
				<div class="lft_hd">
					<a href="index"><img src="<c:url value="/resources/img/logo.png" />" style="width:130px;" alt=""/></a>
				</div>
			</div>			
			<div class="col-lg-9 col-md-9 col-sm-12">
				<div class="rgt_hd">					
					<div class="main_menu">
						<nav id="nav_menu">
							<button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							</button>	
						<div id="navbar">
							<ul>
								<li><a class="page-scroll" href="index">Home</a></li> 
							<li><a href="#">Stock <i class="fa fa-angle-down"></i></a>
							<ul>
								<li><a class="page-scroll" href="stockIn">Stock In</a></li>
								<li><a class="page-scroll" href="stockOut">Stock Out</a></li>
								<li><a class="page-scroll" href="docUpload">Document Upload</a></li>
								<li><a class="page-scroll" href="editStock">Today Stock Detail</a></li>
							</ul>
							</li> 						

							<li><a href="#">Bank<i class="fa fa-angle-down"></i></a>
							<ul>
								<li><a class="page-scroll" href="bankDtl">Bank Account Transactions</a></li>
							</ul>
							</li> 
							
							<li><a class="page-scroll" href="investment">Expenditure</a></li>
							
							<li><a href="#">Customer<i class="fa fa-angle-down"></i></a>
							<ul>
								<li><a class="page-scroll" href="custRegistration">Registration</a></li>
								<li><a class="page-scroll" href="custRegistrationModifyAndSearch">Modify</a></li>
							</ul>
							</li> 
							
								<li><a class="page-scroll" href="retail">Retail</a></li>
								<li><a class="page-scroll" href="workers">Worker Wages</a></li>
								<li><a class="page-scroll" href="productReg">Product Registration</a></li>
								
								<li><a href="<c:url value="/logout" />">Logout</a></li>
							</ul>
						</div>		
						</nav>			
					</div>					
						
				</div>
			</div>	
		</div>	
	</div>	
</header>
<!-- End Header Section -->


	 <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script> 
      <script src="<c:url value="/resources/js/vendor/jquery-1.11.3.min.js" />"></script>

<script src="<c:url value="/resources/js/isotope.pkgd.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%-- <script src="<c:url value="/resources/js/jquery-ui.js" />"></script> --%>
<script src="<c:url value="/resources/js/appear.js" />"></script>
<script src="<c:url value="/resources/js/jquery.counterup.min.js" />"></script>
<script src="<c:url value="/resources/js/waypoints.min.js" />"></script>
<script src="<c:url value="/resources/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/resources/js/showHide.js" />"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.easing.min.js" />"></script>
<script src="<c:url value="/resources/js/scrolling-nav.js" />"></script>
<script src="<c:url value="/resources/js/plugins.js" />"></script>
<!-- Google Map js -->
<!--         <script src="https://maps.googleapis.com/maps/api/js"></script> -->
		<!-- <script>
			function initialize() {
			  var mapOptions = {
				zoom: 14,
				scrollwheel: false,
				center: new google.maps.LatLng(41.092586000000000000, -75.592688599999970000)
			  };
			  var map = new google.maps.Map(document.getElementById('googleMap'),
				  mapOptions);
			  var marker = new google.maps.Marker({
				position: map.getCenter(),
				animation:google.maps.Animation.BOUNCE,
				icon: '/resources/img/map-marker.png',
				map: map
			  });
			}
			google.maps.event.addDomListener(window, 'load', initialize);
		</script> -->
<script src="<c:url value="/resources/js/main.js" />"></script>

<!-- <script src="showHide.js" type="text/javascript"></script> -->

<script type="text/javascript">

$(document).ready(function(){

	$('#loader-wrapper').hide();
   $('.show_hide').showHide({			 
		speed: 1000,  // speed you want the toggle to happen	
		easing: '',  // the animation effect you want. Remove this line if you dont want an effect and if you haven't included jQuery UI
		changeText: 1, // if you dont want the button text to change, set this to 0
		showText: 'View',// the button text to show when a div is closed
		hideText: 'Close' // the button text to show when a div is open
					 
	}); 

});

</script>
<script>
    jQuery(document).ready(function( $ ) {
        $('.counter').counterUp({
            delay: 10,
            time: 1000
        });
    });
</script>

<script>
//Hide Overflow of Body on DOM Ready //
$(document).ready(function(){
    $("body").css("overflow", "hidden");
});

// Show Overflow of Body when Everything has Loaded 
$(window).load(function(){
    $("body").css("overflow", "visible");        
    var nice=$('html').niceScroll({
	cursorborder:"5",
	cursorcolor:"#00AFF0",
	cursorwidth:"3px",
	boxzoom:true, 
	autohidemode:true
	});

});
</script>

<div><br><br><br></div>
</body>
</html>