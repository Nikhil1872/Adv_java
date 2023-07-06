package myServ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaServ
 */
@WebServlet(
		urlPatterns = { "/JavaServ" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "java")
		})
public class JavaServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletConfig config = this.getServletConfig();
		String subject = config.getInitParameter("subject");
		
		ServletContext cntx = this.getServletContext();
		 String provider = cntx.getInitParameter("provider");
		
		out.println("<h3>training on "+subject+" by "+provider+"</h3>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
