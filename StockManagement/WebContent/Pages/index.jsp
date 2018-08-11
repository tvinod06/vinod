<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/Pages/include.jsp" %>
<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Stock Management</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
<body >
<!-- start slider Section --><br><br><br><br>
<section id="slider_sec" style="height: 350px;">
	<div class="container">
		<div class="row">
			<div class="slider">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->

				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox">
					
<!-- start Service Section -->
<section id="pr_sec">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="service">
				<a href="stockIn">						
					<h1 style="color:white">Stock In</h1>
					<div class="service_hoverly">
						<h2>Stock In</h2>
						<p>All Materials/Products bought on this day can be updated here</p>
					</div>
				</div>
			</div>				
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="service">
				<a href="stockOut">						
					<h1 style="color:white">Stock Out</h1>
					<div class="service_hoverly">
						<h2>Stock Out</h2>
						<p>All Materials/Products sold on this day can be updated here</p>
					</div>
				</div>
			</div>				
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="service">
				<a href="docUpload">						
					<h1 style="color:white">Document Upload</h1>
					<div class="service_hoverly">
						<h2>Document Upload</h2>
						<p>All Private and Public Documents can be stored here </p>
					</div>
				</div>
			</div>	
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="service">	
				<a href="getReport">					
					<h1 style="color:white">Reports</h1>
					<div class="service_hoverly">
						<h2>Generate Reports</h2>
						<p>All reports can be generated here</p>
					</div></a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- End Service Section -->
				  </div>
				</div>
			</div>	
		</div>			
	</div>	
</section>
<!-- End slider Section -->

<!-- start Counting section-->
<section id="counting_sec">
<div class="container">
	<div class="row">	

		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
			<div class="counting_sl">
			<h2 class="counter">${display.stockInAmt}</h2>
			<h4>Stock In amount</h4>	
			</div>
		</div>			
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
			<div class="counting_sl">
			<h2 class="counter">${display.stockOutAmt}</h2>
			<h4>Stock Out Amount</h4>	
			</div>
		</div>			
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
			<div class="counting_sl">
			<h2 class="counter">${display.withDrawlAmt}</h2>
			<h4>Bank Withdrawl Amount</h4>	
			</div>
		</div>			
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
			<div class="counting_sl">
			<h2 class="counter">${display.depositAmt}</h2>
			<h4>Bank Deposit Amount</h4>	
			</div>
		</div>
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
			<div class="counting_sl">
			<h2 class="counter">${display.investmentAmt}</h2>
			<h4>Expenditure Amount</h4>	
			</div>
		</div>	
		<div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
			<div class="counting_sl">
			<h2 class="counter">${display.workersAmt}</h2>
			<h4>Worker Wages</h4>	
			</div>
		</div>										
	</div>					
</div>
</section>
<%@ include file="/Pages/footer.jsp" %>
    </body>
</html>
