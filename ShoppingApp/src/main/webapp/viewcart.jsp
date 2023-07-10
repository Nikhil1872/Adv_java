<%@ page language="java" import="java.util.*,java.sql.*,entities.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View CART</title>
</head>
<body>


<%
  User u = (User)session.getAttribute("loggedinuser"); 

%>
<h1>Weclome to cart <%= u.getLname()%></h1>



<%
Connection con = (Connection)application.getAttribute("jdbccon");
		
		List<Integer> sps = (List<Integer>) session.getAttribute("cart");
		
		if(sps==null)
		{
			out.println("<p>Cart is Empty</p>");
	    }
		else
		{
			%>
			<table border=1>
			
			<%
			PreparedStatement ps =null;
			ResultSet rs =null;
			
			try {
				
				ps=con.prepareStatement("select * from product where p_id=?");
				int cnt=0;
				float totalprice=0;
				
				for(int n :sps)
				{
					ps.setInt(1, n);
					rs=ps.executeQuery();
					if(rs.next())
					{
		   %>	
		  
		   <tr>
						<td> <%= ++cnt %> </td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(4) %></td>
						<td> <a href="deleteItem?pid="<%=rs.getInt(1)%> > delete </a>  </td>
				</tr>
				
						<% rs.getString(4);
						totalprice+=Float.parseFloat(rs.getString(4));
					}
				}
				session.setAttribute("totalprice", totalprice);
				%>
				
				
				
				<tr>
				<td colspan='2'> Total price </td>
				<td><%= totalprice %></td>
				</tr>
				</table>
				<br/> <br/> <a href='confirmcart'> Confirm Cart <a/>
				<br/> <br/> <a href='Home'> Go back to Categories <a/>
				
				<%
			}
			    catch(Exception e)
			{
					e.printStackTrace();
				}finally {
					try {
					ps.close();
					rs.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
					
			} %>
				
				
			


</body>
</html>