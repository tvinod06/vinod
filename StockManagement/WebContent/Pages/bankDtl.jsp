<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="edit" value="/resources/img/edit.png"></c:url>
<c:url var="del" value="/resources/img/delete.png"></c:url>
<script src="<c:url value="/resources/script/fileUpload.js"/>">
<% %>
</script>
</head>
<body>
	<form id="bankForm" name="bankForm" action="submitBankForm" enctype="multipart/form-data" method = "post">
	<input type=hidden id="documentId" name="documentId">
	
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Bank Account Transactions</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
				<div id="cnt_form">

					<div class="form-group">
						<div>
							<input type="text" name="purpose" id="purpose"
								class="form-control name-field" required="required"
								placeholder="Purpose">
						</div>
					</div>
					<div class="form-group">
						<select name="category" id="category" class="form-control mail-field"
							required="required">
							<option value="-1">Category</option>
							<c:forEach var="transactionType" items="${transactionTypeLst}">
							<option value="${transactionType.lookupId}">${transactionType.lookupName}</option>
							</c:forEach>
							</select>
					</div>
					<div class="form-group">
						<div>
							<input type="text" name="amount" id="amount"
								class="form-control name-field" required="required"
								placeholder="Amount">
						</div>
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
							<input type="file" name="file" class="form-control name-field" id="file"
								required="required" placeholder="Document Upload" onchange="uploadFile()">
						</div>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary" onclick="submitbankForm()">Submit</button>
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
	
	function submitbankForm(){
		if(document.getElementById('docId').value == '' || document.getElementById('docId').value == null){
			alert("Upload bank receipt.");
			return;
		}
		if(confirm("Do you want to Submit ?")){
			$('#loader-wrapper').show();
			document.bankForm.submit();
		}
	}
	</script>
</body>
</html>