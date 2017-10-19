package controller.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.DBLogin;

/**
 * Servlet implementation class LoginAdmin
 */
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DBLogin dblogin = new DBLogin();
		int result = dblogin.isLogged(username, password, "admin_login", "admin");
		
		if(result > 0) {
			session.setAttribute("admin_id", result);
			rd = request.getRequestDispatcher("/views/admin/homepage.jsp");
			rd.forward(request, response);
		}
		else if(result == 0) {
			request.setAttribute("error", "The password entered is incorrect. Please try again.");
			rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else {
			request.setAttribute("error", "User does not exists! Register for an account.");
			rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
