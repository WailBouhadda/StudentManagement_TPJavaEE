

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
		
		// Delete Students By Age
		
		if(request.getParameter("age")!=null) {
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		int rowsdeleted = ME.deleteStudentsByAge(age);
		
		request.setAttribute("RowsDeleted", rowsdeleted);

		
		request.setAttribute("StuArrList", ME.getStudents());
		request.getRequestDispatcher("StudentTab_J.jsp").forward(request, response);
		}
		
		
		//Delete Student By ID
		
		
		if(request.getParameter("action")!=null) {
			String action = request.getParameter("action");

			
			if(action.equals("delete")) {
			
				HttpSession s = request.getSession();

				int id = (int) s.getAttribute("id");
				
				s.setAttribute("Id", id);
				
				s.setAttribute("Action", action);
		
				ME.deleteStudentById(id);
				
				
			}else
				
				if(action.equals("update")) {
					
					//String validation = "";
					
					/*validation = request.getParameter("validation");
					HttpSession s = request.getSession();
					Student stu = new Student();
					
					

					/*if(validation.equals("save")) {
						
					/*String lastname= request.getParameter("lastname");
					stu.setLastName(lastname);
					String firstname  = request.getParameter("firstname");
					stu.setFirstName(firstname);
					int age = Integer.parseInt("age");
					stu.setAge(age);
					String cne = request.getParameter("cne");
					stu.setCne(cne);
					
					int id = (int) s.getAttribute("id");
					
					s.setAttribute("Id", id);
					
					s.setAttribute("Action", action);
					
					ME.updatestudentById(stu);

					
					}else {
						
						int id = (int) s.getAttribute("id");
						
						s.setAttribute("Id", id);
						
						s.setAttribute("Action", action);
					}*/
					
					
					
					
					
				}
			
		}
		
		request.setAttribute("StuArrList", ME.getStudents());
		request.getRequestDispatcher("StudentTab_J.jsp").forward(request, response);
		
		
		
		
		
		
	}

}
