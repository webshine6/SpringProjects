<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
    
<!DOCTYPE html>
<html>
<head>
	<%@include file="includes/head.jsp" %>
</head>
<body>
	<h1>List Users</h1>
	<h3> Hello,  ${loggedinuser}</h3> 
	
	<div class="containter">
		<div class="row">
           <div class="col-lg-6 col-lg-offset-3">
           		<table class="table table-hover responsive">
					  <thead>
					    <tr>
					      <th>#ID</th>
					      <th>Username</th>
					      <th>Roles</th>
					      <sec:authorize access="hasRole('ADMIN')">
					      	 <th>Action</th>				     
					      </sec:authorize>
					    </tr>
					  </thead>
					  
					  	<tbody>  
					   	<c:forEach items="${users}" var="user">
					      <tr>
					         <td scope="row">${user.userid}</td>
					         <td>${user.username}</td>					     				
							 <td>
						         <c:forEach items="${user.roles}" var="role">
						         		${role.type}					         			
						         </c:forEach>
		          			 </td>
		          			 
					         <td>
					         	<sec:authorize access="hasRole('ADMIN')">					         
						         	<a href="<c:url value='/edit-user-${user.userid}' />" class="btn btn-success">
						         	 Edit
						         	</a>
						         	
						         	<a href="<c:url value='/delete-user-${user.userid}' />" class="btn btn-danger">
						         	 Delete
						         	</a>
					         	</sec:authorize>
					         </td>
					      </tr>
					    </c:forEach>
					   
					  </tbody>
				</table>
           </div>
		</div>	
	</div>
	 
	 <p>
	 	<sec:authorize access="hasRole('ADMIN')">
	 		<a href="<c:url value='/registration' />" class="btn btn-primary">Add New User</a>
	 	</sec:authorize>
	 </p>
	 
	 <br/>
	 
	 <a href="./logout">Logout</a>
</body>
</html>