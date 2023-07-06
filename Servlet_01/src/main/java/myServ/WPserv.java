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

import org.apache.catalina.connector.Response;


@WebServlet(
		urlPatterns = { "/WPserv" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "Web Programming")
		})
public class WPserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
	    ServletContext ctx = this.getServletContext();	
		String provider=ctx.getInitParameter("provider");
		
		ServletConfig cfg = this.getServletConfig();
		String subject = cfg.getInitParameter("subject");
		
		out.println("<h3>taining for "+subject+" by "+provider);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
