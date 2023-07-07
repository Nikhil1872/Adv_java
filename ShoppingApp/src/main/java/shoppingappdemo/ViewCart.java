package shoppingappdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection )config.getServletContext().getAttribute("jdbccon");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		//getting attribute from session
		
		List<Integer> sps = (List<Integer>) session.getAttribute("cart");
		
		if(sps==null)
		{
			out.println("<p>Cart is Empty</p>");
	    }
		else
		{
			out.println("<table border=1>");
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
						out.println("<tr>");
						out.println("<td>"+(++cnt)+"</td>");
						out.println("<td>"+rs.getString(2)+"</td>");
						out.println("<td>"+rs.getString(4)+"</td>");
						out.print("<td> <a href='deleteItem?pid="+ rs.getInt(1)+"'> delete </a>  </td>");
						out.println("</tr>");
						System.out.println(rs.getString(4));
						totalprice+=Float.parseFloat(rs.getString(4));
					}
				}
				session.setAttribute("totalprice", totalprice);
				
				out.println("<tr>");
				out.print("<td colspan='2'> Total price </td>");
				out.print("<td>"+ totalprice + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.print("<br/> <br/> <a href='confirmcart'> Confirm Cart <a/>");
				out.print("<br/> <br/> <a href='Home'> Go back to Categories <a/>");
				
				
			}catch(Exception e)
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
				
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
