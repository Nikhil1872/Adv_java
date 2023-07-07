package shoppingappdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
				
		con= (Connection) config.getServletContext().getAttribute("jdbccon");
		System.out.println("Connection establish for registration ");
		
		
	}
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		String id = request.getParameter("eid");
		System.out.println("id +"+id);
		String pwd = request.getParameter("pass");
		System.out.println("id +"+pwd);
		String fname = request.getParameter("fname");
		System.out.println("id +"+fname);
		String mname = request.getParameter("mname");
		System.out.println("id +"+mname);
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		System.out.println("id +"+email);
		String contact = request.getParameter("mno");
		
		
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
			
			System.out.println(ps);
			
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, lname);
			ps.setString(6, email);
			ps.setString(7, contact);
			
			int n=ps.executeUpdate();
			System.out.println("table updated"); 
			
			System.out.println("n "+n);
			
			if(n==1)
			{
				out.print("user registered succesfully");
				out.print("<a href='http://localhost:8000/ShoppingApp/Login.html' >Login Now </a>");
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}
