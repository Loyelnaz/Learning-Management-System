package controller.instructor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import database.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddModuleController
 */
public class AddModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddModuleController() {
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
		PrintWriter out = response.getWriter();
		
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		System.out.println("Servlet Course ID: " + course_id);
		
		out.print("Module added!");
		request.setAttribute("course_id", course_id);
		RequestDispatcher rd = request.getRequestDispatcher("add_module.jsp");
		rd.include(request, response);
	}

}
