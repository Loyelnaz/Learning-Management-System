<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.util.*" %>
    <%@page language="java" import="java.sql.*" %>
    <%@page language="java" import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>

<a href="profile.jsp">Profile</a><br>
<h4>Courses</h4>

<%
Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;

conn = new DBConnector().getConnection();
ps = conn.prepareStatement("select * from course_table");
rs = ps.executeQuery();

while(rs.next()) {
	out.print("<h5>"+rs.getString(2)+"</h5>");
}
%>
</body>
</html>