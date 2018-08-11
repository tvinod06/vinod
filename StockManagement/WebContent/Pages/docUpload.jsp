<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Pages/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url var="edit" value="/resources/img/edit.png"></c:url>
<c:url var="del" value="/resources/img/delete.png"></c:url>
<script src="<c:url value="/resources/script/fileUpload.js"/>"></script>
</head>
<body>
	<form id="docUploadForm" name="docUploadForm" action="#" method="post">
	<input type=hidden id="documentId" name="documentId">
		<section id="ctn_sec">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs12 ">
			<div class="title_sec">
				<h1>Document Upload</h1>
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
								placeholder="Document Name">
						</div>
					</div>
					<div class="form-group">
						<select name="category" id="category" class="form-control mail-field"
							required="required">
							<option value="-1">Category</option>
							<c:forEach var="categoryList" items="${categoryList}">
									<option value="${categoryList.lookupId}">${categoryList.lookupName}</option>
								</c:forEach>
							</select>
					</div>
					<div class="form-group">
						<div>
							<input type="file" name="file" class="form-control name-field" id="file"
								required="required" placeholder="Document Upload" onchange="uploadFile()">
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>

	</form>
	<script type="text/javascript">
	$('#loader-wrapper').hide();
	</script>
</body>
</html>