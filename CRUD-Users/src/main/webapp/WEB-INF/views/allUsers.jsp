<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<jsp:include page="includes/header.jsp"/>
<jsp:include page="includes/body.jsp"/>
<jsp:include page="includes/footer.jsp"/>
<head>
    <title>List of Users</title>
    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
<%--<h2>List of Users</h2>--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td>First name</td>--%>
<%--<td>Last name</td>--%>
<%--<td>Email</td>--%>
<%--<td>Date of birth</td>--%>
<%--<td>Phone number</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${users}" var="user">--%>
<%--<tr>--%>
<%--<td>${user.firstName}</td>--%>
<%--<td>${user.lastName}</td>--%>
<%--<td>${user.email}</td>--%>
<%--<td>${user.dob}</td>--%>
<%--<td>${user.phoneNumber}</td>--%>
<%--<td><a href="<c:url value='/edit-user-${user.firstName}' />">Edit</a></td>--%>
<%--<td><a href="<c:url value='/delete-user-${user.id}' />">delete</a></td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>

<br/>
<a href="<c:url value='/new' />" class="btn btn-primary new-user">Add New User</a>
</body>
</html>
