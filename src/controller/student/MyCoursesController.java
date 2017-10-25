package controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import database.*;

/**
 * Servlet implementation class MyCourses
 */
public class MyCoursesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCoursesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet course_enroll = null, rs = null;
		
		
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		conn = new DBConnector().getConnection();
		
		try {
			ps = conn.prepareStatement("select * from course_enrolment where uid=?");
			ps.setInt(1, user_id);
			course_enroll = ps.executeQuery();
			
			if(course_enroll.next()) {
				ps = conn.prepareStatement("select * from course_table where course_id=?");
				ps.setInt(1, course_enroll.getInt(2));
				rs = ps.executeQuery();
				
				//if(rs.next()) {
					request.setAttribute("user_courses", rs);
				//}
			}
			
			
//			if(rs.next()) {
//				System.out.println("Something present");
//				System.out.println("USER: " + rs.getString(2) + " Course: " + rs.getString(3));
//				request.setAttribute("user_courses", rs);
				request.getRequestDispatcher("mycourses.jsp").forward(request, response);
//			}
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
