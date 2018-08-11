<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<form id="miscForm" name="miscForm" action="" method="post">

		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Miscellaneous expenses for Business</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
				<div class="form-group">
						<div>
							<input type="text" name="expenseType" id="expenseType" class="form-control name-field" required="required" placeholder="Expense Type">
						</div>
					</div><div id="cnt_form">

					<div class="form-group">
						<div>
							<input type="text" name="amount" id="amount" class="form-control name-field" required="required" placeholder="Amount">
						</div>
					</div>
					<div class="form-group">
						
					</div>
					<div class="form-group">
						
					</div>



					<div class="form-group">
						<div>
							<input type="text" name="reason" id="reason" class="form-control name-field" required="required" placeholder="Reason">
						</div>
					</div>
					<div class="form-group">
						<div>
							
						</div>
					</div>
					<div class="form-group">
						<div>
							
						</div>
					</div>
					<div class="form-group">
						
					</div>
					<div class="form-group">
						<div>
							
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="file" name="file" class="form-control name-field" id="file" required="required" placeholder="Document Upload">
						</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary" onclick="miscFormSubmit()">Submit</button>
					</div>
				</div>
			</div>

			
		</div>
		</section>

	</form>
	<script type="text/javascript">
	if("${success}" != undefined && "${success}" != null && "${success}" != ""){
		alert("${success}");
	}
	function miscFormSubmit(){
		if(confirm("Do you want to Submit ?")){
			$('#loader-wrapper').show();
		document.miscForm.submit();
		}
	}
	
	</script>
</body>
</html>