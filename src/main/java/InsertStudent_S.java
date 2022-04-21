

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackage.Student;
/**
 * Servlet implementation class InsertStudent_S
 */
public class InsertStudent_S extends HttpServlet {
	
	Student E1 = new Student();
	StudentManagement ME = new StudentManagement();
	
	Statement st;
	ResultSet rs,id;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		
		String nom = request.getParameter("lname");
		E1.setLastName(nom);
		
		String prenom = request.getParameter("fname");
		E1.setFirstName(prenom);
		
		int adress = Integer.parseInt(request.getParameter("age"));
		E1.setAge(adress);
		
		String cne = request.getParameter("cne");
		E1.setCne(cne);
		
		
		
		 
		ME.inserStudent(E1);
		
		
		response.sendRedirect("InsertStudent_J.jsp");

		
	
	}


}
