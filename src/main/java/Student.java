import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

	
	 int id;
	 String nom;
	 String prenom;
	 int age;
	 String cne;
	 
	
	
	public Student() {
		// TODO Auto-generated constructor stub
		
		id = this.id;
		nom = this.nom;
		prenom = this.prenom;
		age = this.age;
		cne = this.cne;
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getCne() {
		return cne;
	}
	
	
	public void setCne(String cne) {
		this.cne = cne;
	}

	
}
