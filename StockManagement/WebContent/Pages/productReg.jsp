<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<form id="productRegistration" name="productRegistration" action="submitProdReg" method="post">

		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Product Registration</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
			<div class="form-group">
						<div>
							 <input type="radio" id="newProductFlag" name="newProductFlag" 
								required="required" value="1" onclick="showHideDropdown(this)" checked>&nbsp
							Register New Product &nbsp &nbsp &nbsp &nbsp<input type="radio"
								id="newProductFlag" name="newProductFlag"
								required="required" value="0" onclick="showHideDropdown(this)">&nbsp
							Add Category to Existing Product
						</div>
					</div>
				<div id="newProductDiv" class="form-group">
						<input placeholder="Product Name" type="text" name="newProductName" id="newProductName" class="form-control mail-field"
							required="required">
					</div>
					<div id="exisitngProductDiv" class="form-group" style="display:none">
						<select name="productName" id="productName" class="form-control mail-field"
							required="required" >
							<option value="-1">Product Name</option>
							<c:forEach var="productList" items="${productList}">
							<option value="${productList.productName}">${productList.productName}</option>
							</c:forEach>
							</select>
					</div>

					<div class="form-group">
						<input placeholder="Category" type="text" name="category" id="category" class="form-control mail-field"
							required="required" onkeypress="myFunction()">
					</div>
					
					<div class="form-group">
						<div>
							<textarea placeholder="Description" id="description" name="description"
								class="form-control mail-field" required="required">
							</textarea>
						</div>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-primary" onclick="productRegistrationSubmit()">Submit</button>
					</div>
				</div>
			</div>

			
		</div>
		</section>

	</form>
<script type="text/javascript">

document.getElementById('description').value='';
if("${success}" != undefined && "${success}" != null && "${success}" != ""){
	alert("${success}");
}

function productRegistrationSubmit(){
	if((document.getElementById('newProductDiv').style.display=='none' && document.getElementById('productName').value == '-1') || (document.getElementById('newProductDiv').style.display!='none' && document.getElementById('newProductName').value == '')){
		alert("Enter Product Name.");
		return;
	}
	if(document.getElementById('category').value == ''){
		alert("Enter Category");
		return;
	}
	if(document.getElementById('description').value == ''){
		alert("Enter Description");
		return;
	}
	if(document.getElementById('description').value.length < 4 || document.getElementById('category').value.length < 4 || (document.getElementById('newProductDiv').style.display!='none' && document.getElementById('newProductName').value.length < 4) ){
		alert("Enter more than 3 characters.");
		return;
	}
	if(confirm("Do you want Submit? ")){
		$('#loader-wrapper').show();
		document.productRegistration.url = "/submitProdReg";
		document.productRegistration.submit();
	}
}

function showHideDropdown(val){
	if(val.value == 1){
		document.getElementById('exisitngProductDiv').style.display = "none";
		document.getElementById('newProductDiv').style.display = "block";
	}else{
		document.getElementById('newProductDiv').style.display = "none";
		document.getElementById('exisitngProductDiv').style.display = "block";
	}
}

function myFunction() {
}
	
</script>
</body>
</html>