package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import database.*;

/**
 * Servlet implementation class InstructorApproval
 */
public class InstructorApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorApproval() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = new DBConnector().getConnection();
		try {
			ps = conn.prepareStatement("select * from user_table where is_active=? and ugid=(select ugid from user_group where group_name=?)");
			ps.setBoolean(1, false);
			ps.setString(2, "instructor");
			rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println("Name: " + rs.getString(2));
//			}
			request.setAttribute("inactive", rs);
			request.getRequestDispatcher("instructor_approval.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post");
		request.getRequestDispatcher("instructor_approval.jsp").forward(request, response);
		doGet(request, response);
	}

}
