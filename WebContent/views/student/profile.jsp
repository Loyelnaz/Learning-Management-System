<%@page import="com.sun.prism.Image"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*" %>
    <%@page language="java" import="database.*" %>
    <%@page language="java" import="controller.student.UploadPicture"%>
    <%@page language="java" import="javax.servlet.http.HttpSession" %>
    <%@page language="java" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Student Profile</title>
</head>
<body>

<%@include file="link.jsp"%>

<%
	HttpSession httpsession = request.getSession(true);
	int user_id = (Integer) httpsession.getAttribute("user_id");

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	OutputStream os = null;
	
	conn = new DBConnector().getConnection();
 
%>
	<!-- 
	try {
		ps = conn.prepareStatement("select photo from user_photo where uid=?");
	    ps.setInt(1, user_id);
	    rs = ps.executeQuery();
	 
	    if(rs.next()) {
	    	byte[] imgData = new byte[1048576];
	 		int size = 0;
	 		InputStream image = rs.getBinaryStream("photo");
	 		response.reset();
	        response.setContentType("image/jpg");
	        
	        while((size=image.read(imgData)) != -1) {
	        	response.getOutputStream().write(imgData, 0, size);
	        }
	    }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		response.getOutputStream().flush();
		response.getOutputStream().close();
		rs.close();
		ps.close();
		conn.close();
	}
	-->
<center style="margin-top: 50px"><h4>Student Profile</h4></center>

<center>
	<a href="upload_picture.jsp"><button class="btn btn-primary">Upload Picture</button></a>
	
	<form action="editprofile.jsp" method="post" style="margin-top: 10px">
		<input type="submit" value="Edit Profile" class="btn btn-primary">
	</form>

	<%
		ps = conn.prepareStatement("select * from user_table where uid=?");
		ps.setInt(1, user_id);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			out.print("<center style='margin-top:30px'>");
			out.print("<label>First Name: "+rs.getString(2)+"</label><br>");
			out.print("<label>Middle Name: "+rs.getString(3)+"</label><br>");
			out.print("<label>Last Name: "+rs.getString(4)+"</label><br>");
			out.print("<label>Email ID: "+rs.getString(5)+"</label><br>");
			out.print("<label>Phone No: "+rs.getString(6)+"</label><br>");
			out.print("<label>User Name: "+rs.getString(7)+"</label><br>");
			out.print("</center>");
		}		
	%>
</center>

</body>
</html>