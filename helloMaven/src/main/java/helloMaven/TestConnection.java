package helloMaven;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public TestConnection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/dac";
		Connection con = DriverManager.getConnection(url, "root", "12345");
		
		System.out.println("connection established");

	}

}
