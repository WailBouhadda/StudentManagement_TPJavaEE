

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackage.Student;

/**
 * Servlet implementation class StudentTab_S
 */
public class StudentTab_S extends HttpServlet {
	
	StudentManagement ME = new StudentManagement();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentTab_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("age")!=null) {
		int age = Integer.parseInt(request.getParameter("age"));
		ME.DeleteStudents(age);
		ArrayList<Student> StuList = new ArrayList();
		
		request.setAttribute("StuArrList", ME.getStudents());
		request.getRequestDispatcher("StudentTab_J.jsp").forward(request, response);
		}
		
		
		ArrayList<Student> StuList = new ArrayList();
		
		request.setAttribute("StuArrList", ME.getStudents());
		request.getRequestDispatcher("StudentTab_J.jsp").forward(request, response);
		
		
		
	}

}
