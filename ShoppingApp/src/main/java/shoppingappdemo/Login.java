package shoppingappdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
				
		con= (Connection) config.getServletContext().getAttribute("jdbccon");
		System.out.println("Connection establish");
		
		
	}

	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		System.out.println("u "+uid+" p :"+pwd);
		PrintWriter out = response.getWriter();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			ps= con.prepareStatement("select * from users where u_id=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			System.out.println("ps"+ps);
			rs=ps.executeQuery();
			
			//login
			if(rs.next())
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Home");
				rd.forward(request, response);
				//out.println("<h3>success</h3>");
			}
			else
			{
				response.sendRedirect("/Login.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
