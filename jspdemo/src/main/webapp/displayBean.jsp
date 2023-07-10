<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="bean.User" scope="request" />
<jsp:useBean id="addr" class="bean.address1" scope="request" />
	<h1> Welcome <jsp:getProperty property="fname" name="user"/>
		<jsp:getProperty property="lname" name="user"/>
	</h1>
	Email : <jsp:getProperty property="email" name="user"/>
	<br/>
	Age : <jsp:getProperty property="age" name="user"/>
	<br/>
	City:
      <jsp:getProperty property="city" name="addr"/>

</body>
</html>