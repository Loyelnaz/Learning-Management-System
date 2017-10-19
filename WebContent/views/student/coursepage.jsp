<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*" %>
    <%@page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
courses

<%
ResultSet course = (ResultSet)request.getAttribute("course");
while(course.next()) {
	out.print("<h4>" + course.getString(2) + "</h4><br>");
}
%>

<%
Connection conn = null;
PreparedStatement ps = null;

conn = new DBConnector().getConnection();
int course_id = Integer.parseInt(request.getParameter("course_id"));
ps = conn.prepareStatement("select * from course_content where course_id=?");
ps.setInt(1, course_id);
ResultSet rs = ps.executeQuery();

while(rs.next()) {
	out.print(rs.getString(2) + "<br>" + rs.getString(3) + "<br>");
}
%>
</body>
</html>