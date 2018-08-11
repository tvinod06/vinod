<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/worklist.css" />">
<c:url var="edit" value="/resources/img/edit.png"></c:url>
<c:url var="del" value="/resources/img/delete.png"></c:url>
</head>
<body>
	<form id="editStockForm" name="editStockForm" action="" method="post">

		<section id="ctn_sec">
		<div class="col-sm-6 ">
			<div class="title_sec">
				<h1>Stock Out List</h1>
				<h2></h2>
			</div>
		</div>
		<div class="col-sm-6 ">
			<div class="title_sec">
				<h1>Stock In List</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6 ">
				<p><b>Product List</b></p>
				<table
					class="table muffin table-bordered table-hover margin-bottom0" id="productList" class="container">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Rate per Unit</th>
							<th>Total Amount</th>
						</tr>
						<c:forEach var="stockOut" items="${stockOutLst}">
							<tr>
								<td>${stockOut.productName}</td>
								<td>${stockOut.category}</td>
								<td>${stockOut.quantity}</td>
								<td>${stockOut.ratePerUnit}</td>
								<td>${stockOut.totalAmount}</td>
							</tr>
						</c:forEach>
					</thead>
					<tbody>
					</tbody>
				</table><br><p align="right"><b>
				Total Stock Out Amount : ${totalStockOutAmnt} </b></p>
			</div>

			<div class="col-sm-6 ">
				<p><b>Product List</b></p>
				<table
					class="table muffin table-bordered table-hover margin-bottom0" id="productList" class="container">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Rate per Unit</th>
							<th>Total Amount</th>
						</tr>
						<c:forEach var="stockIn" items="${stockInLst}">
							<tr>
								<td>${stockIn.productName}</td>
								<td>${stockIn.category}</td>
								<td>${stockIn.quantity}</td>
								<td>${stockIn.ratePerUnit}</td>
								<td>${stockIn.totalAmount}</td>
							</tr>
						</c:forEach>
					</thead>
					<tbody>
					</tbody>
				</table><br><p align="right"><b>
				Total Stock In Amount : ${totalStockInAmnt} </b></p> 
			</div>
		</div>
		</section>

	 </form>
	<script type="text/javascript">
		  
	</script>
</body>
</html>