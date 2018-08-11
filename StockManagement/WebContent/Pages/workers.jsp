<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="edit" value="/resources/img/edit.png"></c:url>
<c:url var="del" value="/resources/img/delete.png"></c:url>
</head>
<body>
	<form id="workersForm" name="workersForm" action="workersFormSubmit" method="post">
	<input id="workerList" name="workerList" type="hidden">
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Worker Wages</h1>
				<h2></h2>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-6">
				<div id="cnt_form">
					<div class="form-group">
						<div>
							<input type="text" name="ratePerUnit" id="ratePerUnit"
								class="form-control name-field" required="required"
								placeholder="Rate per Unit" onchange="calculateTotal()">
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="text" name="numOfWorkers" id="numOfWorkers"
								class="form-control name-field" required="required"
								placeholder="Number Of Workers" onblur="add()">
						</div>
					</div>
					<div class="form-group">
						<div>
							<input type="text" id="totalAmount" name="totalAmount" class="form-control name-field"
								required="required" placeholder="Total Amount" readonly="true">
						</div>
					</div>
					<div class="form-group">
						<div>
							<textarea placeholder="Remarks" id="remarks" name="remarks"
								class="form-control name-field" required="required">
							</textarea>
						</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary" onclick="submitworkersForm()">Submit</button>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<span id="multipleWorkers">
				
				</span>
			</div>
		</div>
		</section>

	</form>
	<script type="text/javascript">
	if("${success}" != undefined && "${success}" != null && "${success}" != ""){
		alert("${success}");
	}
	
		function add() {
			array = [];
			list = {};
			document.getElementById("totalAmount").value = '';
			var myNode = document.getElementById("multipleWorkers");
			while (myNode.firstChild) {
			    myNode.removeChild(myNode.firstChild);
			}
			var num = document.getElementById("numOfWorkers").value;
			if(isNaN(num)){
				alert("Enter valid value.");
				document.getElementById("numOfWorkers").value = '';
				return;
			}
			for (var i = 0; i < num; i++) {
				var div = document.createElement("div");
				div.setAttribute("class", "form-group");
				var p = document.createElement("p");
				p.setAttribute("class", "form-group");
				var element = document.createElement("input");
				element.setAttribute("type", "text");
				element.setAttribute("name", "worker"+i);
				element.setAttribute("id", "worker"+i);
				element.setAttribute("placeholder", "Number of Units");
				element.setAttribute("onblur", "createList(this)");
				element.setAttribute("class","form-control name-field");
				var t = document.createTextNode("Worker "+(i+1)+" : ");
			    p.appendChild(t);
				div.appendChild(p);
				div.appendChild(element);
				var spanvar = document.getElementById("multipleWorkers");
				spanvar.appendChild(div);
			}
		}
		var list = {};
		var array = [];
		document.getElementById('remarks').value = '';
		function createList(ele){
			if(document.getElementById("ratePerUnit").value != '' && document.getElementById("ratePerUnit").value != 0 && isNaN(document.getElementById("ratePerUnit").value) == false){
				if(isNaN(ele.value)){
					alert("Enter valid Number of units.");
					document.getElementById(ele.id).value = '';
					return;
				}else{
					list[ele.id] = ele.value;
					array.push([ele.id,ele.value]);
					calculateTotal();
				}
			}else {
				alert("Enter valid Rate per Unit.");
				document.getElementById("ratePerUnit").value='';
				document.getElementById(ele.id).value = '';
			}
		}
		
		function calculateTotal(){
			var rate = document.getElementById("ratePerUnit").value;
			var total=0;
			jQuery.each( list, function(index,value){
				total = +(total) + +(value*rate);
			})
			document.getElementById("totalAmount").value = total;
		}
		
		function submitworkersForm() {
			if(document.getElementById('numOfWorkers').value == ''){
				alert("Enter Number of Workers.");
				return;
			}
			if(document.getElementById('ratePerUnit').value == ''){
				alert("Enter Rate per Unit.");
				return;
			}
			if(array.length != document.getElementById('numOfWorkers').value){
				alert("Enter all Workers details.");
				return;
			}
			if(document.getElementById('remarks').value == ''){
				alert("Enter remarks.");
				return;
			}
			if(confirm("Do you want to Submit ?")){
				$('#loader-wrapper').show();
			document.getElementById('workerList').value = JSON.stringify(array);
			document.workersForm.submit();
			}
		}
	</script>
</body>
</html>