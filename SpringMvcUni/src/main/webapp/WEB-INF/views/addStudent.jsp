<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Student addition</title>
</head>
<body>
	<h1>Student Addition</h1>
	
	<form:form method="POST" action="addStudentSave">
		<table>
			<tr>
				<td>Faculty No: </td>
				<td><input type="text" name="facultyNo"/></td>
				
				<td>Name:</td>
				<td><input type="text" name="name"></td>			
			</tr>
		</table>
			<input type="submit" name="Submit"/>
		
	</form:form>
	
</body>
</html>