
import myPackage.Student;

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
			st.executeUpdate("insert into students values("+E1.getId()+",'"+E1.getLastName()+"','"+E1.getFirstName()+"',"+E1.getAge()+",'"+E1.getCne()+"')");
			
			DBConnection.disconnect();

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
			ST.setLastName(rs.getString(2));
			ST.setFirstName(rs.getString(3));
			ST.setAge(rs.getInt(4));
			ST.setCne(rs.getString(5));
			
			StuArrL.add(ST);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("getStudent error");
	
	}
	DBConnection.disconnect();
	return StuArrL;
	}
	
		
	public int deleteStudentsByAge(int age) {
		int BC=0;
		int AC=0;
		int counter=0;
		con = DBConnection.connect();

		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from students");
			while(rs.next()) {
				++BC;
			}
			st.execute("delete from students where age="+age);
			rs = st.executeQuery("select * from students");
			while(rs.next()) {
				++AC;
			}
			counter = BC - AC;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("InserStudent error");

		}
		
		DBConnection.disconnect();
		return counter;
		
	}
	
	public int deleteStudentById(int id) {
		int delete =0;
		con = DBConnection.connect();
		
		try {
			st = con.createStatement();
			st.execute("delete from students where id="+id);
			delete=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			delete = -1;
		}
		
		DBConnection.disconnect();
		return delete;
		
	}
	
	public int updatestudentById(Student s) {
		
		int cou;
		con = DBConnection.connect();
		
		try {
			st = con.createStatement();
			st.execute("UPDATE etudiant set last name = '"+ s.getLastName() +"', first name = '"+ s.getFirstName() +"',age = "+s.getAge()+",cne = '"+s.getCne()+"' where id = "+s.getId()+" ");
			cou = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cou=-1;
		}
		
		
		return cou;
		
		
	}
	
	public boolean userLogin(String user, String pass) {
		boolean statut=false;
		
		con = DBConnection.connect();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select username, password from users");
			
			while(rs.next()) {
			if(rs.getString(2).equals(user) && rs.getString(3).equals(pass)) {
				
				statut = true;
			}else {
				statut = false;
			}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return statut;
		
		
	}
}
