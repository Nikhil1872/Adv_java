package shopListner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionListner implements ServletContextListener {

   Connection  con;
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	//reading from context para from web.xml file
    	
    	String driver = sce.getServletContext().getInitParameter("driver");
    	String url = sce.getServletContext().getInitParameter("jdbcurl");
    	String user = sce.getServletContext().getInitParameter("user");
    	String pwd = sce.getServletContext().getInitParameter("password");
    	System.out.println("IN LISTNER");
    	
    	try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection set");
			sce.getServletContext().setAttribute("jdbccon", con);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    }
	
}
