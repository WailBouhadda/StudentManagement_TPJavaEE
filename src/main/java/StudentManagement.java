import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentManagement {
	
	
	private  Connection con;
	private  Statement 	st;
	private  ResultSet rs;
	

	public StudentManagement() {
		// TODO Auto-generated constructor stub
		}
	
	public boolean inserStudent(Student E1) {
		con = DBConnection.connect();
		
		try {
			st = con.createStatement();
			st.executeUpdate("insert into students values("+E1.getId()+",'"+E1.getNom()+"','"+E1.getPrenom()+"',"+E1.getAge()+",'"+E1.getCne()+"')");

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InserStudent error");
			return false;
		}
		
	}
		
	
	public ArrayList<Student> getStudents() {
		con = DBConnection.connect();
		ArrayList<Student> StuArrL = new ArrayList();
		
	try {	
		st = con.createStatement();
		rs = st.executeQuery("select * from students");
		while(rs.next()) {
			Student ST =  new Student();
			ST.setId(rs.getInt(1));
			ST.setNom(rs.getString(2));
			ST.setPrenom(rs.getString(3));
			ST.setAge(rs.getInt(4));
			ST.setCne(rs.getString(5));
			
			StuArrL.add(ST);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("getStudent error");
	
	}
	return StuArrL;
	}
	
		

}
