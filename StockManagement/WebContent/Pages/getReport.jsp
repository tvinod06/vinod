<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</script>
</head>
<body>
	<form id="getReportForm" name="getReportForm" action="getReportDtls" enctype="multipart/form-data" method = "post">
	<input type=hidden id="documentId" name="documentId">
	
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Generate Reports</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
				<div id="cnt_form">

					<div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs3">From Date</div>
					<div class="form-group col-lg-9 col-md-9 col-sm-9 col-xs9">
						<input type="date" name="frmDate" id="frmDate" class="form-control name-field" required="required" placeholder="From Date">
					</div>
					<div class="form-group col-lg-3 col-md-3 col-sm-3 col-xs3">To Date</div>
					<div class="form-group col-lg-9 col-md-9 col-sm-9 col-xs9">
						<input type="date" name="toDate" id="toDate" class="form-control name-field" required="required" placeholder="To Date">
					</div>
					
					<div class="form-group">
						<button type="button" class="btn btn-primary" onclick="generateReport()">Generate</button>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div id="cnt_form">

					<div class="form-group">
						<select name="pageOrientation" id="pageOrientation" class="form-control mail-field"
							required="required">
							<option value="-1">Page Orientation</option>
							<option value="0">Portrait</option>
							<option value="1">Landscape</option>
							</select>
					</div>
					
				</div>
			</div>
		</div>
		</section>

	</form>
	<script type="text/javascript">
	$('#loader-wrapper').hide();
	
	if("${error}" != undefined && "${error}" != null && "${error}" != ""){
		alert("${error}");
	}
	if("${path}" != undefined && "${path}" != null && "${path}" != ""){
		alert("Report is saved in ${path}");
	}
	
	function generateReport(){
		if(document.getElementById("frmDate").value == ''){
			alert("Select From Date.");
			return;
		}
		if(document.getElementById("toDate").value == ''){
			alert("Select To Date.");
			return;
		}
		if(document.getElementById("toDate").value < document.getElementById("frmDate").value){
			alert("To Date should be greater than From Date.");
			return;
		}
		if(document.getElementById("pageOrientation").value == '-1'){
			alert("Select Page Orientation.");
			return;
		}
		if(confirm("Do you want to Generate ?")){
			$('#loader-wrapper').show();
			document.getReportForm.submit();
		}
	}
	</script>
</body>
</html>