<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sec:csrfMetaTags/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Management</title>
<style type="text/css">
body {
	background:rgba(48, 55, 58, 0.72);
}

.jumbotron {
	text-align: center;
	width: 450px;
	border-radius: 0.5rem;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	position: absolute;
	margin: 4rem auto;
	background-color: #fff;
}

.container .glyphicon-list-alt {
	font-size: 10rem;
	margin-top: 3rem;
	color: #f96145;
}

input {
	width: 300px;
	margin-bottom: 1.4rem;
	padding: 1rem;
	background-color: #ecf2f4;
	border-radius: 0.2rem;
	border: none;
}

h2 {
	margin-bottom: 3rem;
	font-weight: bold;
	color: #ababab;
}

.btn {
	border-radius: 0.2rem;
}

.btn .glyphicon {
	font-size: 30px;
	color: #fff;
}

.full-width {
	background-color: #8eb5e2;
	width: 330px;
    height: 45px;
	-webkit-border-top-right-radius: 0;
	-webkit-border-bottom-right-radius: 0;
	-moz-border-radius-topright: 0;
	-moz-border-radius-bottomright: 0;
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
}

.box {
	position: absolute;
	bottom: 0;
	left: 0;
	margin-bottom: 3rem;
	margin-left: 3rem;
	margin-right: 3rem;
}
</style>

</head>
<script type="text/javascript">

let searchParams = new URLSearchParams(window.location.search);

var error = searchParams.get('error');
var logout = searchParams.get('logout');

if(error != undefined && error != null && error != ""){
	alert("Username / Password is incorrect.");
}

if(logout != undefined && logout != null && logout != ""){
	alert("You are logged out Successfully.");
}

</script>
<body>
	<div class="jumbotron">
		<div class="container">
 			<span class="glyphicon glyphicon-list-alt"></span>
			<h2>Stock Management System</h2>
			<div class="box">
			<form name="formLogin" action="<c:url value='j_spring_security_check'/>"
                    method="POST">
				<input type="text" placeholder="username" name="j_username"> 
				<input type="password" placeholder="password" name="j_password">
				<button class="btn btn-default full-width" type="submit" name="submit">
 					<span class="glyphicon glyphicon-ok">></span>
				</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>