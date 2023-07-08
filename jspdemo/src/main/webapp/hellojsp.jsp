<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<h1 Style={}>Welcome to jsp</h1>

<br/>
This is template
<br/>
<!-- This is HTML comment -->

<br/>
<%--This is Jsp Comment --%>
<br/>

<%
  out.print("This is scriplet --Write your java code here");
  int n =0;
out.print("Value of n :"+(++n));
%>
<br/>
<%
out.print(Calendar.getInstance().getTime());
%>

<%= Calendar.getInstance().getTime()%>>

<br/>
<%! int iVar; %> 
<%="value of iVar "+(++iVar) %>




</div>

</body>
</html>