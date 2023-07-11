<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Comments for topics</h1>
<table border='1' >

<c:forEach var="comment" items="${comments}">
		
	
		<tr><td> ${comment.cid}</td> 
		
		<td>${comment.text}</td> 
		<!-- <td>${comment.topicid}</td>  -->
		<td>${comment.uid}</td>
		
		</tr> 
		
		
	</c:forEach>
	</table>

</body>
</html>