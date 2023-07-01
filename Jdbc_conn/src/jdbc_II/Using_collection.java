package jdbc_II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
public class Using_collection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/dac";
		Connection con = DriverManager.getConnection(url, "root", "12345");
		
		System.out.println("connection established");
		
		PreparedStatement ps = con.prepareStatement("select * from emp");
		
		
		ResultSet rs = ps.executeQuery();
		
        HashSet<Emp> emps = new HashSet<>();
        
        
		
		while(rs.next())
		{
			Emp e = new Emp(rs.getInt(1),rs.getString(2),rs.getInt(8),rs.getFloat(6));
			emps.add(e);
				
		}
		
		for(Emp e :emps)
		{
			System.out.println(e);
		}



	}

}
