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
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	OutputStream os = null;
	
	conn = new DBConnector().getConnection();
 
%>
<!-- 
ps = conn.prepareStatement("select * from user_photo where uid=?");
    ps.setInt(1, user_id);
    rs = ps.executeQuery();
 
    if(rs.next()){
    	Blob image = rs.getBlob(2);
    	byte[] imgData = image.getBytes(1,(int)image.length());
 
        response.setContentType("image/jpg");
        os = response.getOutputStream();
        out.print(os.write(imgData));
        os.flush();
        os.close();
    } -->
<center style="margin-top: 50px"><h4>Student Profile</h4></center>

<!--<center>
	
	<form action="editprofile.jsp" method="post">
		<a href="upload_picture.jsp"><button class="btn btn-primary">Upload Picture</button></a>
		<input type="submit" value="Edit Profile" class="btn btn-primary">
	</form>
</center>-->

<%
	if(httpsession != null) {
		if(httpsession.getAttribute("user_id") != null) {
			int user_id = (Integer) httpsession.getAttribute("user_id");
	
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
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
	
%>

</body>
</html>