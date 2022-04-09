

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	
	Student E1 = new Student();
	Statement st;
	ResultSet rs,id;
	StudentManagement ME = new StudentManagement();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int coun = 0;
		
		String nom = request.getParameter("lname");
		E1.setNom(nom);
		
		String prenom = request.getParameter("fname");
		E1.setPrenom(prenom);
		
		int adress = Integer.parseInt(request.getParameter("age"));
		E1.setAge(adress);
		
		String cne = request.getParameter("cne");
		E1.setCne(cne);
		
		
		
		 
		ME.inserStudent(E1);
		
		
	    PrintWriter out = response.getWriter();
	    
	    //Student Infos In HTML Table
	    out.println("<html>");
	    
	    out.println("<head>");
	    out.println("<link rel=\"stylesheet\" href=\"Style.css\">");
	    out.println("<title>DataBase Table</title>");
	    out.println("</head>");
	    
	   
	    out.println("<body>");
	    
	    //create html table
	    out.println("<table class=\"table\">");
		
	    out.println("<thead>");
	    
	    out.println("<tr>");
	   
	    out.println("<th>ID</th> <th>Last Name</th> <th>First Name</th> <th>Age</th> <th>CNE</th>");

	    out.println("</tr>");
	    
	    out.println("</thead>");
	    
	    out.println("<tbody>");

	    //fetch data from DB to table
	    ArrayList<Student> StuList = new ArrayList();
	    Student Stu = new Student();
	    
	    StuList = ME.getStudents();
	    

			for(int i = 0 ; i < StuList.size() ; i++) {
				out.println("<tr>");
				Stu = StuList.get(i);
				out.println("<td>"+Stu.getId()+"</td> <td>"+Stu.getNom()+"</td> <td>"+Stu.getPrenom()+"</td> <td>"+Stu.getAge()+"</td> <td>"+Stu.getCne()+"</td>");
				 out.println("</tr>");
			}
			
	    
	    out.println("</tbody>");
	    
	    out.println("</table>");
	    

	    out.println("</body>");
	    out.println("</html>");

        //disconnect
        DBConnection.disconnect();

	}

}
