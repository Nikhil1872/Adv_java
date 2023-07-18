package myServlet;

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


@WebServlet("/StudentServ")
public class StudentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		con= (Connection) config.getServletContext().getAttribute("jdbccon");
		System.out.println("Connection establish");
		
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		int sem1 = Integer.parseInt( request.getParameter("sem1"));
		int sem2 = Integer.parseInt( request.getParameter("sem2"));
		int sem3 = Integer.parseInt( request.getParameter("sem3"));
		int sem4 = Integer.parseInt( request.getParameter("sem4"));
		
		int sum = sem1+sem2+sem3+sem4;
		float avg = sum/4;
		String grade="";
		if(avg>=90)
			grade="Excellent";
		else if(avg>=80 &&avg<90)
			grade="Very Good";
		else if(avg>=70 && avg<80)
			grade="Good";
		else if(avg>=60 && avg<70)
			grade="Average";
		else if(avg>=40 && avg<60)
			grade="Pass";
		else
			grade="fail";
		
		out.print("<table boder='1'>");
		out.print("<tr><td>"+name+"</td>");
		out.print("<td>"+email+"</td>");
		out.print("<td>"+contact+"</td>");
		out.print("<td>"+avg+"</td>");
		out.print("<td>"+grade+"</td>");
		out.print("</tr></table>");
		
	   //saving info
		
PreparedStatement ps = null;
		
		try {
			ps= con.prepareStatement("insert into students(sname,email,contact,average,grade) values(?,?,?,?,?)");
			 ps.setString(1,name );
			 ps.setString(2,email);
			 ps.setString(3,contact);
			 ps.setFloat(4, avg);
			 ps.setString(5, grade);
			 
			 int n = ps.executeUpdate();
			 
			 if(n==1)
			 {
				 out.println("<h3>student details saved succesfully</h3>");
			 }
			 else
			 {
				 out.println("<h3>error in inserting record to database</h3>");
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
