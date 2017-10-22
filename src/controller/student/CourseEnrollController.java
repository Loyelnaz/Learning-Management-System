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
 * Servlet implementation class CourseEnrollController
 */
public class CourseEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEnrollController() {
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
		
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		
		conn = new DBConnector().getConnection();
		
		try {
			ps = conn.prepareStatement("insert into course_enrolment values (?,?)");
			ps.setInt(1, user_id);
			ps.setInt(2, course_id);
			ps.executeUpdate();
			
			request.setAttribute("isEnrolled", true);
			request.getRequestDispatcher("coursepage.jsp?course_id="+course_id+"").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
