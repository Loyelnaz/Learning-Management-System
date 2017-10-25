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
 * Servlet implementation class QuizScoreReportController
 */
public class QuizScoreReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizScoreReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		Connection conn = null;
		PreparedStatement ps = null, ps1 = null;
		ResultSet rs = null, quiz_report = null;
		
		conn = new DBConnector().getConnection();
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		int course_id = Integer.parseInt(request.getParameter("course_id"));

		try {
			int u_id = 0;
			ps = conn.prepareStatement("select uid from user_table where username=? and ugid=?");
			ps.setString(1, username);
			ps.setInt(2, 2);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				u_id = rs.getInt(1);
			}
			
			ps = conn.prepareStatement("SELECT qs.score, cc.module_no, cc.module_name from quiz_score qs inner join course_content cc on qs.course_id=cc.course_id and qs.module_no=cc.module_no and qs.course_id=? and qs.uid=?");
			ps.setInt(1, course_id);
			ps.setInt(2, u_id);
			quiz_report = ps.executeQuery();
			
			if(quiz_report.isBeforeFirst()) {
				request.setAttribute("quiz_report", quiz_report);
				request.setAttribute("message", "");
			}
			else {
				request.setAttribute("message", "The user has not attempted any quiz.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("quizreport.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
