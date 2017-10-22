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
 * Servlet implementation class CourseContentController
 */
public class CourseContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseContentController() {
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
		ResultSet enrolled = null;
		
		conn = new DBConnector().getConnection();
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		
		try {
//			int user_id = (Integer) httpsession.getAttribute("user_id");
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			ps = conn.prepareStatement("select uid from course_enrolment where course_id=? and uid='"+user_id+"'");
			ps.setInt(1, course_id);
			enrolled = ps.executeQuery();
			
			if(enrolled.next()) {
				request.setAttribute("isEnrolled", true);
				request.getRequestDispatcher("coursepage.jsp?course_id="+course_id+"").forward(request, response);
			}
			else {
				request.setAttribute("isEnrolled", false);
				request.getRequestDispatcher("coursepage.jsp?course_id="+course_id+"").forward(request, response);
			}
			
//			ps = conn.prepareStatement("select * from course_table where course_id=?");
//			ps.setInt(1, course_id);
//			course = ps.executeQuery();
//			
//			if(course.next()) {
//				System.out.println("Name: " + course.getString(2));
//				request.setAttribute("course", course);
//				request.getRequestDispatcher("coursepage.jsp").forward(request, response);
//			}
			
//			ps = conn.prepareStatement("select * from course_content where course_id=? order by module_no");
//			ps.setInt(1, course_id);
//			course_modules = ps.executeQuery();
//			
//			if(course_modules.next()) {
//				request.setAttribute("course_modules", course_modules);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		int course_id = Integer.parseInt(request.getParameter("course_id"));
		System.out.println("Enroll Now");
//		request.getRequestDispatcher("/views/student/coursepage.jsp").forward(request, response);
//		response.sendRedirect("coursepage.jsp?course_id='"+course_id+"'");
//		request.getRequestDispatcher("coursepage.jsp").forward(request, response);
//		request.getRequestDispatcher("coursepage.jsp?course_id="+course_id+"").forward(request, response);
//		doGet(request, response);
		
	}

}
