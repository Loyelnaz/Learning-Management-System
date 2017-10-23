<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile - Student</title>
</head>
<body>

<%@include file="link.jsp"%>

<h4>Student Edit Profile</h4>

<%
	HttpSession httpsession = request.getSession(true);
	int user_id = (Integer) httpsession.getAttribute("user_id");

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	conn = new DBConnector().getConnection();
	ps = conn.prepareStatement("select * from user_table where uid=?");
	ps.setInt(1, user_id);
	rs = ps.executeQuery();
	
	if(rs.next()) {
%>
<form action="editprofile" method="post">
	<input type="text" value="<%=rs.getString("first_name")%>" name="first_name"><br>
	<input type="text" value="<%=rs.getString("middle_name")%>" name="middle_name"><br>
	<input type="text" value="<%=rs.getString("last_name")%>" name="last_name"><br>
	<input type="text" value="<%=rs.getString("emailid")%>" name="emailid"><br>
	<input type="text" value="<%=rs.getString("phoneno")%>" name="phoneno"><br>
	<input type="text" value="<%=rs.getString("username")%>" name="username"><br>
	<input type="submit" value="Save">
</form>
<%} %>
</body>
</html>