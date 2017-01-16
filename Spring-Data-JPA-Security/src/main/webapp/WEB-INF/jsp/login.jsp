<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<%@include file="includes/head.jsp" %>
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body> 
	<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">         
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
                   
            <input name="password" type="password" class="form-control" placeholder="Password"/>
       		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            <c:if test="${param.error != null}">
				<p>
					Invalid username and password.
				</p>
			</c:if>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

</div>
<!-- /container -->
</body>
</html>