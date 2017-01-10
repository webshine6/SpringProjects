<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Spring Forms -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!-- Spring Messaging -->
<%@ taglib prefix="msg" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="?language=en">English</a>
<a href="?language=bg">Български</a>
<a href="?language=es">Español</a>

<h1><msg:message code="create_address"/></h1>

<sf:form commandName="address">

	<msg:message code="city"/>	
	<sf:input path="city"/> </br>	
	
	<msg:message code="street"/>
	<sf:input path="street"/>  </br>
	
	<msg:message code="number"/>
	<sf:input path="number"/>  </br>
	
	<input type="submit" value="<msg:message code="create_address"/>"/>
</sf:form>



</body>
</html>