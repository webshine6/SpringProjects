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

    <form:form method="POST" modelAttribute="user" class="form-signin">
        <h2 class="form-signin-heading">Create user account</h2>
       
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control"
                			placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

		<spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="email" path="email" class="form-control"
                			placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>
		

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
      
        <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
					<div class="col-md-7">
						<form:select path="roles" items="${roles}" multiple="true"
						 itemValue="roleid" itemLabel="type" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="roles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
			<c:choose>
				<c:when test="${edit}">
				   <input type="submit" value="Update" class="btn btn-lg btn-primary btn-block" />
				   or <a href="<c:url value='/list' />">Cancel</a>
				</c:when>
				<c:otherwise>
				   <input type="submit" value="Register" class="btn btn-lg btn-primary btn-block" />
					or <a href="<c:url value='/list' />">Cancel</a>
				</c:otherwise>
				
			</c:choose>	
    </form:form>

</div>
<!-- /container -->
</body>
</html>