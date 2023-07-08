<%@page import="java.util.Calendar,java.text.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
SimpleDateFormat sdf = new SimpleDateFormat("HH");
String hours =sdf.format(Calendar.getInstance().getTime());
int hh = Integer.parseInt(hours);
if(hh<12)
{ %>
     <%= "<h3>Good morning<h3>" %>
     <% 
     }
     else if(hh>=12 && hh<=16)
     {%>
     <%= "<h3>Good Afternoon <h3>" %>
     <%
     }
     else if(hh>=12 && hh<=16)
     {%>
     <%= "<h3>Good Evening <h3>" %>
     <%
     }
     else
     {
     %>
     <%= "<h3>Good Night<h3>" %>
     <%} %>
     

</body>
</html>