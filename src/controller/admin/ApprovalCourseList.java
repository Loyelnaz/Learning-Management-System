package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		HttpSession session = request.getSession(true);
		
//		int user_id = (Integer) session.getAttribute("admin_id");
		
		conn = new DBConnector().getConnection();
		try {
			ps = conn.prepareStatement("select * from course_table where is_active=?");
			ps.setBoolean(1, false);
			rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println("Name: " + rs.getString(2));
//			}
			if(rs.next()) {
				System.out.println("Course_name: " + rs.getString(2));
				request.setAttribute("inactive", rs);
			}
			
			request.getRequestDispatcher("course_approval.jsp").forward(request, response);
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
		doGet(request, response);
	}

}
