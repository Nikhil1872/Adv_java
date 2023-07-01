package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

public class Dept_Avgsal_sort {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url ="jdbc:mysql://localhost:3306/dac";
		
		Connection con = DriverManager.getConnection(url, "root", "12345");
		System.out.println("establish connection");
		
        Statement st = con.createStatement(); //empty container
		 
		ResultSet rs = st.executeQuery("select dept.DNAME,avg(emp.SAL) from emp,dept where emp.deptno=dept.deptno group by dept.DNAME order by avg(emp.SAL) ");  //
		
		
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getFloat(2));
		}
		
		
		

	}

}
