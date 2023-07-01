package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn_Jdbc1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//above method loads the class in memory 
		//when class is loaded static block get executed
		//driver register itself with driver manager
		
		
		//step2:-establish connection with db
		
		String url ="jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection(url,"root", "12345");
		
		System.out.println("connection establish");
		
		
		//steep3:-creating statement
		Statement st = con.createStatement();  //empty container for query
		
		//step4.:-executing the statement
		
		//1.using executeQuery
       ResultSet rs = st.executeQuery("select * from emp");
       
       //Que.2(i coomented this becoz both update and select operation cannot be done simultaneously)
       //2. using executeUpdate()  ...it returns no of rows affected so pls catch it in int type
       //int n  = st.executeUpdate("update emp set sal=9999.00 where eid=102");
       
      // System.out.println("rows affected: "+n);
       
       while(rs.next())
       {
    	   System.out.print(rs.getInt(1)+" ");
    	   System.out.print(rs.getString(2) +" ");
    	   System.out.println(rs.getInt(3)+" "+rs.getFloat(5));
       }
		
		
		
		
		
		
		
		
		
		

	}

}
