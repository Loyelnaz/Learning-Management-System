package controller.student;

import database.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CourseListController
 */
public class CourseListController extends HttpServlet {
	
	String name;
	String description;
	ArrayList<CourseListController> courses = new ArrayList<>();
	
	public CourseListController(String name, String description) {
		this.name = name;
		this.description = description;
		courses.add(this);
		System.out.println(courses.get(0));
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseListController() {
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
		PrintWriter out = response.getWriter();
		conn = new DBConnector().getConnection();
//		CourseListController clc = new CourseListController();
		ArrayList<CourseListController> courses = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement("select * from course_table");
			rs = ps.executeQuery();
			
//			while(rs.next()) {
//				CourseListController clc = new CourseListController(rs.getString(2), rs.getString(3));
//				out.print("<h5>"+rs.getString(2)+"</h5>");
//				clc = new CourseListController(rs.getString(2), rs.getString(3));
//				clc.addCourses(rs.getString(2), rs.getString(3));
				//System.out.println(courses.indexOf(clc));
			//}
			//String person = "Sankalp";
			request.setAttribute("rs", rs);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
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
