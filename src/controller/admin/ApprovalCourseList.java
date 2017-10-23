package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import database.*;

/**
 * Servlet implementation class ApprovalCourseList
 */
public class ApprovalCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalCourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = new DBConnector().getConnection();
		try {
			ps = conn.prepareStatement("select * from course_table where is_active=?");
			ps.setBoolean(1, false);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				request.setAttribute("inactive", rs);
			}
			
			request.getRequestDispatcher("course_approval.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
