package jdbc_II;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display_Emp_Details {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/dac";
		Connection con = DriverManager.getConnection(url, "root", "12345");
		
		System.out.println("connection established");
		
		PreparedStatement ps = con.prepareStatement("select * from emp where EMPNO=?");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter empid");
		
		int empid=Integer.parseInt(br.readLine());
		
	
		
		ps.setInt(1,empid);
		
		ResultSet rs = ps.executeQuery();
			
		if(rs.next())
	    System.out.println("[ Empid: "+rs.getInt(1)+" Name: "+rs.getString(2)+" sal:"+rs.getString(3)+" "+rs.getFloat(6));
		
		else
		System.out.println("***pls enter valid empid****");	
		


	}

}
