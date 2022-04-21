

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Login_S
 */
public class Login_S extends HttpServlet {
	
	StudentManagement SM = new StudentManagement();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String LoginFailed = "";
		
		String user = request.getParameter("username");
		String pass= request.getParameter("password");
			
		if(SM.userLogin(user, pass)) {
			
			response.sendRedirect("InsertStudent_J.jsp");
			
			LoginFailed = "false";
		}else {
		
			LoginFailed = "true";
			
			request.setAttribute("Failed", LoginFailed);
			request.getRequestDispatcher("Login_J.jsp").forward(request, response);

		}
	}

 
	}
