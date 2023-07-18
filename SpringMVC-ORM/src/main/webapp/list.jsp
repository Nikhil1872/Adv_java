<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>List of contacts</h1>
<table border="1">
<f:forEach var="contact" items="${contactlist} ">
<tr>

<td> ${contactlist.fname }</td>
<td> ${contactlist.lname }</td>
<td> ${contactlist.email }</td>
<td> ${contact.contact }</td>
</tr>

</f:forEach>



</body>
</html>