package jdbc_II;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;


public class Sort_onEname {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dac";
		Connection con = DriverManager.getConnection(url, "root","12345");
		System.out.println("connection establish");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from emp");
		
		Set<Emp> emps = new TreeSet<>();
		
		while(rs.next())
		{
			//System.out.println(rs.getInt(1));
			Emp e = new Emp(rs.getInt(1),rs.getString(2),rs.getInt(8),rs.getFloat(6));
			emps.add(e);
		}
		
		for( Emp e: emps)
		{
			System.out.println(e);
		}
		

	}

}
