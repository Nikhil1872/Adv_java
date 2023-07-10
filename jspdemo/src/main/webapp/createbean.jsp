<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--Ctreate or access beann --%>

<jsp:useBean id="user" class="bean.User" scope="request"/>

<jsp:setProperty name="user"  property="*" /> 

<jsp:useBean id="addr" class="bean.address1" scope="request"/>

<jsp:setProperty name="addr"  property="*" /> 
 <jsp:forward page="/displayBean.jsp" />   
 
 
 
<%-- 
///FOLLOWING IS CREATING BEAN USING SETTING PROPERTY OF EACH ATTRIBUTE///


<jsp:useBean id="Address" class="bean.Address" scope="request"/>
<jsp:setProperty property="user" name="uid"/>
<jsp:setProperty property="user" name="fname" param="fname"/>
<jsp:setProperty property="user" name="mname" param="mname"/>
<jsp:setProperty property="user" name="lname" param="lname"/>
<jsp:setProperty property="user" name="email" param="email"/>
<jsp:setProperty property="user" name="contact" param="contact"/>
<jsp:setProperty property="user" name="age" param="age"/>
<jsp:setProperty property="address" name="*"/>
--%>
<%--  all the bean properties should be populated with the 
	request parameters having the same name as that of property --%>
	
	

</body>
</html>