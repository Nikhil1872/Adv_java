package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetCommentsbyuid")
public class GetCommentsbyuid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection) config.getServletContext().getAttribute("jdbccon");
	}

       
   
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int tid =Integer.parseInt(request.getParameter("tid"));
	  PrintWriter out = response.getWriter();
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  
	  try {
		  
		  ps= con.prepareStatement("select * from comment where topicid=?");
		  ps.setInt(1, tid);
		  rs= ps.executeQuery();
		  
		  out.print("<table border=1>");
		  while(rs.next())
		  {
			  out.print("<tr>");
			  out.print("<td>"+rs.getInt(1)+"</td>");
			  out.print("<td>"+rs.getString(2)+"</td>");
			  out.print("<td>"+rs.getString(4)+"</td>");
			  out.print("</tr>");
		  }
		  out.print("</table>");
		  
		  
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }finally {
		  try {
		  ps.close();
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
