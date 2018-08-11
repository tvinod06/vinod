<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="/resources/script/fileUpload.js"/>"></script>
</head>
<body>

	<form id="investmentForm" name="investmentForm" action="submitExpenseForm"  enctype="multipart/form-data" method="post">
	<input type=hidden id="documentId" name="documentId">
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Expenditure Form</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
			<div class="form-group">
						<div>
						<select name="expenseType" id="expenseType" class="form-control mail-field"
							required="required" >
							<option value="-1">Expense Type</option>
							<c:forEach var="expenseList" items="${expenseList}">
									<option value="${expenseList.lookupId}">${expenseList.lookupName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				<div class="form-group">
						<div>
							<input type="text" name="productName" id="productName" class="form-control name-field" required="required" placeholder="Product Name">
						</div>
					</div><div id="cnt_form">

					<div class="form-group">
						<div>
							<input type="text" name="purpose" id="purpose" class="form-control name-field" required="required" placeholder="Purpose">
						</div>
					</div>
					<div class="form-group">
						<input type="text" name="quantity" id="quantity" class="form-control mail-field"
							required="required" placeholder="Quantity" onblur="calcTotalAmnt()">
					</div>
					<div class="form-group">
						<input type="text" name="ratePerUnit" id="ratePerUnit"
							class="form-control mail-field" required="required"
							placeholder="Rate Per Unit" onblur="calcTotalAmnt()">
					</div>
					<div class="form-group">
						<div>
							<input type="text" name="totalAmount" id="totalAmount" class="form-control name-field" required="required" placeholder="Total Amount" readonly="true">
						</div>
					</div>
					<div class="form-group">
							<textarea placeholder="Description" id="remarks" name="remarks"
								class="form-control name-field" required="required">
							</textarea>
						</div>
					<div class="form-group">
						<div>
							<input type="file" name="file" class="form-control name-field" id="file" required="required" placeholder="Document Upload" onchange="uploadFile()">
						</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary" onclick="investmentFormSubmit()">Submit</button>
					</div>
				</div>
			</div>

			
		</div>
		</section>

	</form>
	<script type="text/javascript">
	document.getElementById('remarks').value = '';
	$('#loader-wrapper').hide();
	if("${success}" != undefined && "${success}" != null && "${success}" != ""){
		alert("${success}");
	}
	
	function investmentFormSubmit(){
		
		if(document.getElementById('expenseType').value == '-1'){
			alert("Select Expense Type.");
			return;
		}
		if(document.getElementById('productName').value == ''){
			alert("Enter Product name.");
			return;
		}
		if(document.getElementById('purpose').value == ''){
			alert("Enter Purpose.");
			return;
		}
		if(document.getElementById('ratePerUnit').value == ''){
			alert("Enter Rate per Unit.");
			return;
		}
		if(document.getElementById('quantity').value == ''){
			alert("Enter Quantity.");
			return;
		}
		if(document.getElementById('remarks').value == ''){
			alert("Enter remarks.");
			return;
		}
		if(confirm("Do you want to Submit ?")){
			$('#loader-wrapper').show();
		document.investmentForm.submit();
		}
	}
	function calcTotalAmnt(){
		var ratePerUnit = document.getElementById('ratePerUnit').value;
		var quantity = document.getElementById('quantity').value;
		if(isNaN(ratePerUnit) || isNaN(quantity)){
			alert("Alphabets / Special characters are not allowed");
			document.getElementById('ratePerUnit').value = '';
			document.getElementById('quantity').value = '';
			document.getElementById('totalAmount').value = '';
			return;
		}
		if(ratePerUnit != '' && quantity != ''){
			document.getElementById('totalAmount').value = (ratePerUnit*quantity);
		}else{
			document.getElementById('totalAmount').value = '';
		}
	}
	function uploadFile(){
		
		var oMyForm = new FormData();
		oMyForm.append("file", file.files[0]);
		oMyForm.append("purpose", document.getElementById('purpose').value);
		oMyForm.append("category", document.getElementById('expenseType').value);
		oMyForm.append("documentMstId", document.getElementById('documentId').value);
		  
		jQuery.ajax({
		    url: 'uploadFile',
		    data: oMyForm,
		    dataType: 'text',
		    cache: false,
		    contentType: false,
		    processData: false,
		    type: 'POST',
		    
		    success: function(data){
		    	var jsonData = JSON.parse(data);
		    	if(jsonData.docId != null && jsonData.docId != ''){
		    		document.getElementById('documentId').value = jsonData.docId;
		    		alert("File uploaded successfully.");
		    	}else{
		    		alert("Could not upload file. Please try later.");
		    	}
		    }
		});
	}
	</script>
</body>
</html>