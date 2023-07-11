package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Comment;
import entities.Topic;


@WebServlet("/GetComments")
public class GetComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
   
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con=(Connection) config.getServletContext().getAttribute("jdbccon");
	}

	

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			System.out.println("above con");
			
			st = con.createStatement();
			rs=st.executeQuery("select * from comments");
			
			System.out.println("rs "+rs);
			//List<Topic> topics = new ArrayList();
			List<Comment> comments = new ArrayList();
			
			while(rs.next())
			{
				System.out.println("hello");
				//Topic t = new Topic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				Comment c = new Comment(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				//topics.add(t);
				comments.add(c);
				
				
			}
			//getServletContext().setAttribute("topics", topics);
			getServletContext().setAttribute("comments", comments);
			
			RequestDispatcher rd = request.getRequestDispatcher("/comments.jsp");
			rd.forward(request, response);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
			rs.close();
			st.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
