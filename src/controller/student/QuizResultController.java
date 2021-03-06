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
 * Servlet implementation class QuizResultController
 */
public class QuizResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizResultController() {
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
		
		Connection conn = null;
		PreparedStatement ps = null, ps1 = null;
		ResultSet quiz = null, quiz_result = null;
		
		conn = new DBConnector().getConnection();
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		int module_no = Integer.parseInt(request.getParameter("module_no"));
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		
		try {
			int quiz_score = 0;
			ps = conn.prepareStatement("select * from quiz_questions where course_id=? and module_no=?");
			ps.setInt(1, course_id);
			ps.setInt(2, module_no);
			quiz = ps.executeQuery();
			
			while(quiz.next()) {
				String option1 = request.getParameter("option1"+quiz.getInt(9));
				String option2 = request.getParameter("option2"+quiz.getInt(9));
				String option3 = request.getParameter("option3"+quiz.getInt(9));
				String option4 = request.getParameter("option4"+quiz.getInt(9));

				if(option1 != null) {
					if(option1.equals(quiz.getString(8))) {
						quiz_score = quiz_score + 1;
					}
				}
				else if(option2 != null) {
					if(option2.equals(quiz.getString(8))) {
						quiz_score = quiz_score + 1;
					}
				}
				else if(option3 != null) {
					if(option3.equals(quiz.getString(8))) {
						quiz_score = quiz_score + 1;
					}
				}
				else if(option4 != null) {
					if(option4.equals(quiz.getString(8))) {
						quiz_score = quiz_score + 1;
					}
				}
			}
			System.out.println("Quiz Score: " + quiz_score);
			request.setAttribute("quiz_score", quiz_score);
			ps = conn.prepareStatement("insert into quiz_score values (?,?,?,?)");
			ps.setInt(1, course_id);
			ps.setInt(2, module_no);
			ps.setInt(3, user_id);
			ps.setInt(4, quiz_score);
			int i = ps.executeUpdate();
			
			if(i > 0) {
				System.out.println("Quiz Score added");
			}
			
			ps1 = conn.prepareStatement("SELECT qs.score, count(qq.question_no) from quiz_score qs inner join quiz_questions qq on qs.course_id=qq.course_id and qs.module_no=qq.module_no group by qs.score");
			quiz_result = ps1.executeQuery();
			
			request.setAttribute("quiz_result", quiz_result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("quizresult.jsp").forward(request, response);
	}

}
