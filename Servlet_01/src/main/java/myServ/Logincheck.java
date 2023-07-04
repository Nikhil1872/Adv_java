package myServ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logincheck
 */
@WebServlet("/Logincheck")
public class Logincheck extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/test";
			con = DriverManager.getConnection(jdbcUrl, "root", "12345");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		System.out.println("uid: "+uid);
	    System.out.println("pwd: "+pwd);
		
		
		
	
		//this is for static check
	/*	if(uid.equals("object") && pwd.equals("knowit"))
			  out.print("<h3> welcome "+uid+"</h3>");
		else
			out.print("<h2>login failed</h2>");
			
	*/
		//this is for dynamic checkk from server it require jdbc connection
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from emp where ename=? and pass=?");
		    ps.setString(1, uid);
		    ps.setString(2,pwd);
		    
		    rs = ps.executeQuery(); 
		   
		    
		    
		    
		    if(rs.next())
		    {
		    	System.out.println(rs.getString(2));
			    System.out.println(rs.getString(4));
		    	if(rs.getString(2).equals(uid) && rs.getString(4).equals(pwd))
		    	{
		    		out.print("<h3>Login Success</h3>");
		    	}
		    }
		    else
		    {
		    	out.print("<h3>failed login</h3>");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				if(rs!=null)
				 rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
