<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="del" value="/resources/img/delete.png"></c:url>
<script src="<c:url value="/resources/script/fileUpload.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/worklist.css" />">
</head>
<body>

	<form id="custRegistration" name="custRegistration" action="submitCustReg" method="post">
	<input id="documentId" name="documentId" type="hidden">
	<input id="prodMap" name="prodMap" type="hidden">
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Customer Registration Details</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
				<div id="cnt_form">
					<p align="center"><b>Customer Details</b></p>
					<div class="form-group">
						<div>
							<input type="text" name="customerName" id="customerName" class="form-control name-field" required="required" placeholder="Name">
						</div>
					</div>
					<div class="form-group">
						<select name="frequency" id="frequency" class="form-control mail-field"
							required="required">
							<option value="-1">Frequency</option>
							<c:forEach var="orderFreqList" items="${orderFreqList}">
									<option value="${orderFreqList.lookupId}">${orderFreqList.lookupName}</option>
								</c:forEach>
							</select>
					</div>
					<div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs3">Start Date</div>
					<div class="form-group col-lg-9 col-md-9 col-sm-9 col-xs9">
						<input type="date" name="startDate" id="startDate" class="form-control name-field" required="required" placeholder="Start Date">
					</div>
					<div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs3">End Date</div>
					<div class="form-group col-lg-9 col-md-9 col-sm-9 col-xs9">
						<input type="date" name="endDate" id="endDate" class="form-control name-field" placeholder="End Date">
					</div>
					<div class="form-group">
						<div>
							<textarea placeholder="Remarks" id="remarks"
								class="form-control name-field" required="required">
							</textarea>
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="file" name="file" class="form-control name-field" id="file" required="required" placeholder="Document Upload" onchange="uploadFile('customer registration')">
						</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary" onclick="custRegistrationSubmit()">Submit</button>
					</div>
				</div>
			</div>
		<div class="col-sm-6">
				<div id="cnt_form">
				<p align="center"><b>Customer Product Details</b></p>
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
						<div>
							<input type="text" name="scale" id="scale" class="form-control name-field" required="required" placeholder="Scale">
						</div>
					</div>
					<div class="form-group" style="float: center">
						<center><button type="button" class="btn btn-primary"
							onclick="addTableRow()">Add</button></center>
					</div>
					
					<p><b>Product List</b></p>
				<table
					class="table muffin table-bordered table-hover margin-bottom0"
					name="productList" id="productList" class="container">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Category</th>
							<th>Scale</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				
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
	document.getElementById("scale").value = '';
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

function addTableRow() {
	var product = document.getElementById("productName").value;
	var c = document.getElementById("category");
	var category = c.options[c.selectedIndex].text;
	var scale = document.getElementById("scale").value;
	if (product == '-1') {
		alert("Select Product Name.");
		return;
	} else if (category == '-1') {
		alert("Select Category Name.");
		return;
	} else if (scale == '') {
		alert("Enter Scale.");
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
		cell1.innerHTML = document.getElementById("productName").value;
		cell2.innerHTML = category;
		cell3.innerHTML = document.getElementById("scale").value;
		cell4.innerHTML = "<center><a href=\"#\" onclick=\"deleteRow(this)\"><img width=20px src=\"${del}\" /></a></center>";
		array.push([ c.value, cell1.innerHTML, cell2.innerHTML,	cell3.innerHTML, cell4.innerHTML ]);
		map[c.value] = array;
	}
	reset();
}


function custRegistrationSubmit(){
	if (array[0] == undefined) {
		alert("Add Customer Product details");
		return;
	}
	if (document.getElementById('frequency').value == '-1') {
		alert("Select Frequency");
		return;
	}
	if (document.getElementById('customerName').value == '') {
		alert("Enter Customer Name");
		return;
	}
	if (document.getElementById('remarks').value == '') {
		alert("Enter remarks");
		return;
	}
	if (document.getElementById('startDate').value == '') {
		alert("Choose Start Date.");
		return;
	}
	if(confirm("Do you want to Submit ?")){
		$('#loader-wrapper').show();
	document.getElementById('prodMap').value = JSON.stringify(array);
	document.custRegistration.submit();
	}
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