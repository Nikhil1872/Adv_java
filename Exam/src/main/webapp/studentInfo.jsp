<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Student info</h1>

<form action="post" action="StudentServ">
Enter name: <input type="text" name="name">
<br>
<br>
Enter email: <input type="text" name="email">
<br><br>
Enter contact: <input type="text" name="contact">
<br><br>
Enter marks for sem1: <input type="number" name="sem1">
<br><br>
Enter marks for sem2: <input type="number" name="sem2">
<br><br>
Enter marks for sem3: <input type="number" name="sem3">
<br><br>
Enter marks for sem4: <input type="number" name="sem4">
<br><br>

<input type="submit" value="submit">



</form>
</body>
</html>