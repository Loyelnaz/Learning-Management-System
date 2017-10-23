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
 * Servlet implementation class AddCourseController
 */
public class AddCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseController() {
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
		PreparedStatement ps = null;
		conn = new DBConnector().getConnection();
		
		String course_name = request.getParameter("course_name");
		String course_description = request.getParameter("course_description");
		int category = Integer.parseInt(request.getParameter("category"));
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		
		try {
			ps = conn.prepareStatement("insert into course_table (course_name, course_description, catid, uid, is_active) values (?,?,?,?,?)");
			ps.setString(1, course_name);
			ps.setString(2, course_description);
			ps.setInt(3, category);
			ps.setInt(4, user_id);
			ps.setBoolean(5, false);
			int i = ps.executeUpdate();
			
			System.out.println(i + " course added");
			ps = conn.prepareStatement("select course_id from course_table where course_name=?");
			ps.setString(1, course_name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				request.setAttribute("course_id", rs.getInt(1));
			}

			request.getRequestDispatcher("add_module.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
