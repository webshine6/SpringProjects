<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Hello World!</h2>

	<c:if test="${not empty list}">
		<ul>
			<c:forEach var="listItem" items="${list}">
			 	<li>${listItem}</li>
		   </c:forEach>
		</ul>
	</c:if>

</body>
</html>
