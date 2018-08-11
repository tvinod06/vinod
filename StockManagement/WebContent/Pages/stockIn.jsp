<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/css/worklist.css" />">
<c:url var="edit" value="/resources/img/edit.png"></c:url>
<c:url var="del" value="/resources/img/delete.png"></c:url>
<script src="<c:url value="/resources/script/fileUpload.js"/>"></script>
</head>
<body>
	<form id="stockInForm" name="stockInForm" action="submitStockIn"
		enctype="multipart/form-data" method="post">
		<input id="prodMap" name="prodMap" type="hidden"> <input
			id="documentId" name="documentId" type="hidden">
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Stock In form</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
				<div id="cnt_form">

					<div class="form-group">
						<div>
							<select name="productName" id="productName"
								class="form-control mail-field"
								onchange="getCategory()">
								<option value="-1">Product Name</option>
								<c:forEach var="productList" items="${productList}">
									<option value="${productList.productName}">${productList.productName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<select name="category" id="category"
							class="form-control mail-field" >
							<option value="-1">Category</option>
						</select>
					</div>
					<div class="form-group">
						<input type="text" name="quantity" id="quantity"
							class="form-control mail-field"
							placeholder="Quantity" onblur="calcTotalAmnt()">
					</div>
					<div class="form-group" style="float: right">
						<center><button type="button" class="btn btn-primary"
							onclick="addTableRow()">Add</button></center>
					</div>
					</br>
					</br>
					</br>
					</br>
					<p><b>Product List</b></p>
				<table
					class="table muffin table-bordered table-hover margin-bottom0"
					name="productList" id="productList" class="container">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Rate per Unit</th>
							<th>Total Amount</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				
				</div>
			</div>

			<div class="col-sm-6 ">
			<div id="cnt_form">
			<div class="form-group">
						<input type="text" name="ratePerUnit" id="ratePerUnit"
							class="form-control mail-field" 
							placeholder="Rate Per Unit" onblur="calcTotalAmnt()">
					</div>

					<div class="form-group">
						<div>
							<input type="text" name="totalAmount" id="totalAmount"
								class="form-control name-field" 
								placeholder="Total Amount" readonly="readonly">
						</div>
					</div><br style="line-height:50px;">
					<div class="form-group" style="float: left;">
						<center><button type="button" class="btn btn-primary"
							onclick="reset()">Reset</button></center>
					</div>
			<br><br><br><br><br><br>
				<div class="form-group">
						<div>
							<select name="paymentMode" id="paymentMode"
								class="form-control mail-field" 
								onchange="getCategory()">
								<option value="-1">Payment Mode</option>
								<c:forEach var="paymentMode" items="${paymentModeList}">
									<option value="${paymentMode.lookupId}">${paymentMode.lookupName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="text" name="bankAmnt" id="bankAmnt"
								class="form-control name-field" 
								placeholder="Total Amount Available" readonly="true">
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="text" name="totalStockInAmnt" id="totalStockInAmnt"
								class="form-control name-field" 
								placeholder="Total Stock In Amount" readonly="true">
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="text" name="inHandAmnt" id="inHandAmnt"
								class="form-control name-field" 
								placeholder="Extra amount spent">
						</div>
					</div>
					<div class="form-group">
						<div>
							Receipt &nbsp &nbsp <input type="radio" id="receiptFlag"
								name="receiptFlag" checked>
							Yes &nbsp <input type="radio" id="receiptFlag" name="receiptFlag"> No
						</div>
					</div>
					<div class="form-group">
						<div>
							<textarea placeholder="Remarks" id="remarks" name="remarks"
								class="form-control name-field" >
							</textarea>
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="file" name="file" class="form-control name-field"
								id="file"  placeholder="Document Upload"
								onchange="uploadFile('stock In')">
						</div>
					</div>
			
				<br>
				<div class="form-group">
					<button type="button" class="btn btn-primary"
						onclick="submitStockInForm()">Submit</button>
				</div>
			</div>
			</div>
		</div>
		</section>

	</form>
	<script type="text/javascript">
		var array = [];
		var map = {};
		document.getElementById('remarks').value = '';
		$('#loader-wrapper').hide();
		if("${success}" != undefined && "${success}" != null && "${success}" != ""){
			alert("${success}");
		}
		
		function reset(){
			document.getElementById("productName").value = '-1';
			document.getElementById("category").value = '-1';
			document.getElementById("quantity").value = '';
			document.getElementById("ratePerUnit").value = '';
			document.getElementById("totalAmount").value = '';
		}
		
		function calcTotalAmnt() {
			var ratePerUnit = document.getElementById('ratePerUnit').value;
			var quantity = document.getElementById('quantity').value;
			if (isNaN(ratePerUnit) || isNaN(quantity)) {
				alert("Alphabets / Special characters are not allowed");
				document.getElementById('ratePerUnit').value = '';
				document.getElementById('quantity').value = '';
				document.getElementById('totalAmount').value = '';
				return;
			}
			if (ratePerUnit != '' && quantity != '') {
				document.getElementById('totalAmount').value = (ratePerUnit * quantity);
			} else {
				document.getElementById('totalAmount').value = '';
			}
		}

		function submitStockInForm() {
			if (array[0] == undefined) {
				alert("Add Stock in Product details");
				return;
			}
			if (document.getElementById('remarks').value == '') {
				alert("Enter remarks");
				return;
			}
			if (document.getElementById('receiptFlag').value == '1'
					&& document.getElementById('file').value == '') {
				alert("Upload File");
				return;
			}
			if (document.getElementById('paymentMode').value == '-1') {
				alert("Select Payment Mode.");
				return;
			}
			if(confirm("Do you want to Submit ?")){
				$('#loader-wrapper').show();
			document.getElementById('prodMap').value = JSON.stringify(array);
			document.stockInForm.submit();
			}
		}

		function addTableRow() {
			var product = document.getElementById("productName").value;
			var c = document.getElementById("category");
			var category = c.options[c.selectedIndex].text;
			var quantity = document.getElementById("quantity").value;
			var ratePerUnit = document.getElementById("ratePerUnit").value;
			var amnt = document.getElementById("totalAmount").value;
			if (product == '-1') {
				alert("Select Product Name.");
				return;
			} else if (category == '-1') {
				alert("Select Category Name.");
				return;
			} else if (quantity == '') {
				alert("Enter Quantity.");
				return;
			} else if (ratePerUnit == '') {
				alert("Enter Rate per Unit.");
				return;
			} else if (amnt == '') {
				alert("Enter Amount.");
				return;
			}
			if (map.hasOwnProperty(c.value)) {
				alert("Same Product and Category is already added.");
			} else {
				var table = document.getElementById("productList");
				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);
				cell1.innerHTML = document.getElementById("productName").value;
				cell2.innerHTML = category;
				cell3.innerHTML = document.getElementById("quantity").value;
				cell4.innerHTML = document.getElementById("ratePerUnit").value;
				cell5.innerHTML = document.getElementById("totalAmount").value;
				document.getElementById("totalStockInAmnt").value = +(document
						.getElementById("totalStockInAmnt").value)
						+ +(document.getElementById("totalAmount").value);
				//cell6.innerHTML = "<a href=\"\" onclick=\"updateRow(this)\"><img width=26px src=\"${edit}\" /></a> &nbsp <a href=\"\" onclick=\"updateRow(this)\"><img width=26px src=\"${del}\" onclick=\"deleteRow()\"/></a>";
				cell6.innerHTML = "<center><a href=\"#\" onclick=\"deleteRow(this)\"><img width=20px src=\"${del}\" /></a></center>";
				array.push([ c.value, cell1.innerHTML, cell2.innerHTML,	cell3.innerHTML, cell4.innerHTML, cell5.innerHTML ]);
				map[c.value] = array;
			}
			reset();
		}

		function deleteRow(row) {
			var j = row.parentNode.parentNode.parentNode.rowIndex;
			for(var i=0; i<array.length;i++){
				if((row.parentNode.parentNode.parentNode.childNodes[0].textContent) == (array[i][1])){
					if((row.parentNode.parentNode.parentNode.childNodes[1].textContent) == (array[i][2])){
						 delete map[array[i][0]];
						 array.splice(i, 1);
						 break;
					}
				}
			}
			document.getElementById('productList').deleteRow(j);
			return;
		}

		function getCategory() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
			}
			var url = "getCategoryList?productName="
					+ document.getElementById('productName').value;
			xmlhttp.open("GET", url, true);
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4) {
					if (xmlhttp.status == 200) {
						var jsonData = JSON.parse(xmlhttp.responseText);
						var element = document.getElementById('category');
						element.options.length = 1;
						for (var i = 0; i < jsonData.category.length; i++) {
							element.options[element.options.length] = new Option(
									jsonData.category[i].category,
									jsonData.category[i].productUniqueId);
						}
					} else {
						alert('Something is wrong !!');
					}
				}
			};

			xmlhttp.send(null);
		}
	</script>
</body>
</html>