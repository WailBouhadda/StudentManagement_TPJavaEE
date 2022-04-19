import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;


public class DBConnection{

	private static Connection con;
	private static Statement 	st;
	private static String driver	= "com.mysql.cj.jdbc.Driver";
	private	static String url 		= "jdbc:mysql://localhost:3306/scolarite";
	private	static String username = "root";
	private	static String pass 	= "";	
	private static ResultSet rs;
		
	
	
	static  Connection connect() {
	
	try {
			Class.forName(driver);


			try {	
					con = DriverManager.getConnection(url,username,pass);
				

					return con;
				
			}catch(SQLException e) {
				
					System.out.println("connection Failed");
				
			}
	} catch (ClassNotFoundException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();		
		
			System.out.println("Driver Not Found");
	}
	return con;
		
	}
	

	
	static void disconnect() {
		
		try {
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Disconnection Failed");
		}
		
		
	}



}				
		
	




	


