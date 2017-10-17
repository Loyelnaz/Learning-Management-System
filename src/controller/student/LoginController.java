package controller.student;

import database.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
//		doGet(request, response);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = new DBConnector().getConnection();
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(true);
		
		String username = request.getParameter("username");
		
		try {
			String password = Crypto.encrypt(request.getParameter("password"));
			ps = conn.prepareStatement("select * from user_table where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = conn.prepareStatement("select uid from user_table where username=? and password=?");
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					int userid = rs.getInt(1);
					//session.setAttribute("user_id", userid);
					rd = request.getRequestDispatcher("/views/student/homepage");
					rd.forward(request, response);
				}
				else {
					out.print("The password entered is incorrect. Please try again.");
					rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			}
			else {
				out.print("User does not exists! Register for an account.");
				rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
