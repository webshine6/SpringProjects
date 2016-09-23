<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<html>
	<head>
		<title>Student Registry</title>
	</head>
<body>
	<h1>
		Student Registry
	</h1>
	
	<button type="button" onclick="location = '${contextPath}${addStudentUrl}'">Add Student</button>
	<table border="1">
		<thead>
			<tr>
				<th>Faculty Number</th>
				<th>Name</th>
			</tr>
		</thead>
		
		<c:if test="${not empty students}">		
			<tbody>			
				<c:forEach var="s" items="${students}">
						<tr>
							<td>${s.facultyNo}</td>
							<td>${s.name}</td>
						</tr>
				</c:forEach>
				
			</tbody>
		</c:if>
	</table>




</body>
</html>
