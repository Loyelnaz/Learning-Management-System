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
 * Servlet implementation class StudentReportController
 */
public class StudentReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReportController() {
        super();
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
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		
		try {
			ps = conn.prepareStatement("SELECT first_name, last_name, emailid, username from course_enrolment ce inner join user_table ut on ce.uid=ut.uid and ce.course_id=? and ugid=?;");
			ps.setInt(1, course_id);
			ps.setInt(2, 2);
			enrolled = ps.executeQuery();
			
			if(enrolled.isBeforeFirst()) {
				request.setAttribute("enrolled", enrolled);
				request.setAttribute("message", "");
			}
			else {
				request.setAttribute("message", "No student has enrolled yet");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("enrolreport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
