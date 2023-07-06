package myServ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServ
 */
@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
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
		
		String id=request.getParameter("eid");
		String name=request.getParameter("ename");
		String deptno=request.getParameter("dept");
		String pass=request.getParameter("pass");
		String sal=request.getParameter("sal");
		
		PreparedStatement ps = null;
		
		try {
			ps= con.prepareStatement("insert into emp(eid,ename,deptno,pass,sal) values(?,?,?,?,?)");
			 ps.setString(1, id);
			 ps.setString(2,name);
			 ps.setString(3,deptno);
			 ps.setString(4, pass);
			 ps.setString(5, sal);
			 
			 int n = ps.executeUpdate();
			 
			 if(n==1)
			 {
				 out.println("<h3>emp registered Succesfully</h3>");
			 }
			 else
			 {
				 out.println("<h3>error in registering emp</h3>");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
