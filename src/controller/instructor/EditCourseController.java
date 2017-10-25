package controller.instructor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import database.*;

/**
 * Servlet implementation class EditCourseController
 */
public class EditCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet edit_courses = null;
		
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		conn = new DBConnector().getConnection();
		
		try {
			ps = conn.prepareStatement("select * from course_table where uid=? and course_id=?");
			ps.setInt(1, user_id);
			ps.setInt(2, course_id);
			edit_courses = ps.executeQuery();
			
			if(edit_courses.isBeforeFirst()) {
				request.setAttribute("edit_courses", edit_courses);
			}
			
			request.getRequestDispatcher("editcourse.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
//		doGet(request, response);
	}

}
