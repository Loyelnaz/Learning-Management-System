package controller.admin;

import java.io.IOException;
import java.sql.*;
import database.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InstructorApprovalController
 */
public class InstructorApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorApprovalController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement ps = null;
		RequestDispatcher rd = null;
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		conn = new DBConnector().getConnection();
		
		try {
			ps = conn.prepareStatement("update user_table set is_active=? where uid=? and ugid=?");
			ps.setBoolean(1, true);
			ps.setInt(2, uid);
			ps.setInt(3, 1);
			ps.executeUpdate();
			
			rd = request.getRequestDispatcher("/views/admin/instructor_approval");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
