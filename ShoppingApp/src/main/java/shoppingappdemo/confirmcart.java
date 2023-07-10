package shoppingappdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.User;


@WebServlet("/confirmcart")
public class confirmcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("loggedinuser");
		
		//insert info into database
		
		String uid = u.getUid();
		System.out.print("Uid :"+uid);
		
		java.sql.Timestamp ts = new java.sql.Timestamp(new java.util.Date().getTime());
		System.out.print("time "+ts);
		
		float totalprice = (float) session.getAttribute("totalprice");
		System.out.print("total price "+totalprice);
		
		
		//display the response
		
		out.print("<p> Order is confirmed </p>");
		out.print("<p> You bill will be emailed at "+ u.getEmail()+"</p>");
		out.print("<p> You will receive message on"+ u.getContact() +" before order delivery </p>");
		
		out.print("<br/> <br/> <a href='Logout'> Logout <a/>");
		out.print("<br/> <br/> <a href='Home'> Want to set new order? <a/>");

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
		
		
	}

}
