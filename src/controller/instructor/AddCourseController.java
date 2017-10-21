package controller.instructor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Connection conn = null;
		PreparedStatement ps = null;
		conn = new DBConnector().getConnection();
		
		String course_name = request.getParameter("course_name");
		String course_description = request.getParameter("course_description");
		int category = Integer.parseInt(request.getParameter("category"));
		
		System.out.println(course_name);
		System.out.println(course_description);
		System.out.println(category);
		
		try {
			ps = conn.prepareStatement("insert into course_table (course_name, course_description, catid) values (?,?,?)");
			ps.setString(1, course_name);
			ps.setString(2, course_description);
			ps.setInt(3, category);
			int i = ps.executeUpdate();
			
			System.out.println(i + " course added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
