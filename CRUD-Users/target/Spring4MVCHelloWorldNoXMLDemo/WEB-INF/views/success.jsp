<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Enrollment Detail Confirmation</title>

</head>
<body>
<div class="success">
    Confirmation message : ${success}
    <br>

    Go back to list <a href="<c:url value="/list" /> ">List of all Users</a>

</div>
</body>
</html>