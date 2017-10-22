package controller.student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import database.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadPicture
 */
@MultipartConfig
public class UploadPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Connection conn = null;
		int result = 0;
		
		conn = new DBConnector().getConnection();
		Part part = request.getPart("photo");
		
		HttpSession httpsession = request.getSession(true);
		int user_id = (Integer) httpsession.getAttribute("user_id");
		
		if(part != null) {
			try{
			    PreparedStatement ps = conn.prepareStatement("insert into user_photo values(?, ?)");
			    InputStream is = part.getInputStream();
			    ps.setInt(1, user_id);
			    ps.setBlob(2, is);
			    result = ps.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			finally
			{
				if(conn != null){
					try{
						conn.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		if(result > 0) {
			response.sendRedirect("profile.jsp");
		}
	}

}
