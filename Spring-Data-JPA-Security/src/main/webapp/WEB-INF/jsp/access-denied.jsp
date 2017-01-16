<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="includes/head.jsp" %>
</head>
<body>
	<div class="generic-container">
		<div class="authbar">
			<span>Dear <strong>${loggedinuser}</strong>,
			 You are not authorized to access this page.</span>
			 
			 <span class="floatRight">
			    <a href="./logout">Logout</a>
			 </span>
		</div>
	</div>
</body>
</html>