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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		Crypto cr = new Crypto();
		
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String last_name = request.getParameter("last_name");
		String emailid = request.getParameter("emailid");
//		Integer phoneno = Integer.parseInt(request.getParameter("phoneno"));
		String phoneno = request.getParameter("phoneno");
		String username = request.getParameter("username");
//		String password;
//		try {
//			password = cr.encrypt(request.getParameter("password"));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		
		conn = new DBConnector().getConnection();
		
		try {
			String password = cr.encrypt(request.getParameter("password"));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//response.sendRedirect("index.jsp");
		}
	}

}
