package controller.student;

import database.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
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
		//doGet(request, response);
		
		Connection conn = null;
		PreparedStatement ps = null;
		conn = new DBConnector().getConnection();
		
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String last_name = request.getParameter("last_name");
		String emailid = request.getParameter("emailid");
		String phoneno = request.getParameter("phoneno");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean status = false;
		
		if(first_name.equals("")) {
			request.setAttribute("first_name", "First Name cannot be null");
			status = true;
		}
		else if(last_name.equals("")) {
			request.setAttribute("last_name", "Last Name cannot be null");
			status = true;
		}
		else if(emailid.equals("")) {
			request.setAttribute("emailid", "Email ID cannot be null");
			status = true;
		}
		else if(phoneno.equals("")) {
			request.setAttribute("phoneno", "Phone No cannot be null");
			status = true;
		}
		else if(username.equals("")) {
			request.setAttribute("username", "User Name cannot be null");
			status = true;
		}
		
		if(status) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		try {
			password = Crypto.encrypt(password);
			ps = conn.prepareStatement("insert into user_table "
									   + "(first_name, middle_name, last_name, emailid, phoneno, username, password, ugid, is_active)"
									   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, first_name);
			ps.setString(2, middle_name);
			ps.setString(3, last_name);
			ps.setString(4, emailid);
			ps.setString(5, phoneno);
			ps.setString(6, username);
			ps.setString(7, password);
			ps.setInt(8, 2);
			ps.setBoolean(9, true);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//response.sendRedirect("login.jsp");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
