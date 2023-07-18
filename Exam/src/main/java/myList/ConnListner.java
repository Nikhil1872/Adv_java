package myList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ConnListner
 *
 */
@WebListener
public class ConnListner implements ServletContextListener {

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
    	
    	String driver = sce.getServletContext().getInitParameter("driverclass");
    	String url = sce.getServletContext().getInitParameter("jdbcurl");
    	String user = sce.getServletContext().getInitParameter("user");
    	String pwd = sce.getServletContext().getInitParameter("password");
    	System.out.println(driver);
    	
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
