package myServ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/DBMSserv" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "DataBase Management")
		})
public class DBMSserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("/Header");
		rd.include(request, response);
		
		ServletContext ctx = this.getServletContext();
		String provider =ctx.getInitParameter("provider");
		
		ServletConfig cfg = this.getServletConfig();
		String subject = cfg.getInitParameter("subject");
		
		out.println("<h3>Training on "+subject+" by "+provider+" <h3>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
