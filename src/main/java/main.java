

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import myPackage.Student;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentManagement ME = new StudentManagement();
		
		Student E1 = new Student();
		Statement st;

	
		
		Scanner src2 = new Scanner(System.in);
		System.out.println("Last Name : ");
		String nom = src2.nextLine();
		E1.setLastName(nom);
		
		Scanner src3 = new Scanner(System.in);
		System.out.println("First Name : ");
		String prenom = src3.nextLine();
		E1.setFirstName(prenom);
		
		Scanner src4 = new Scanner(System.in);
		System.out.println("Adress : ");
		String adress = src4.nextLine();
		E1.setAdress(adress);
		
	
		

		
		DBConnection.connect();
		

		
	
		
	boolean inst = ME.inserStudent(E1);

	System.out.println("Insertion succeed ?:"+inst);

		ME.getStudents();
		
		DBConnection.disconnect();
	}
		

}
