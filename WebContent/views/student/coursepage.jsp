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
Courses

<%
	Connection conn = null;
	PreparedStatement ps = null;
	int i = 1;
	Boolean isEnrolled = (Boolean)request.getAttribute("isEnrolled");
	conn = new DBConnector().getConnection();
	
	int course_id = Integer.parseInt(request.getParameter("course_id"));
	ps = conn.prepareStatement("select * from course_content where course_id=?");
	ps.setInt(1, course_id);
	ResultSet rs = ps.executeQuery();
	
	if(isEnrolled) {
		out.print("(Enrolled)");
		out.print("<br>");
		while(rs.next()) {
			out.print("Module " + i + ": " + rs.getString(2) + "<br>");
			out.print("<i>" + rs.getString(3) + "</i><br>");
			i = i + 1;
		}
	}
	else {
		out.print("(Not Enrolled)");
		out.print("<br>");
		out.print("<a href='coursepage?course_id="+rs.getInt(1)+"'>Enroll Now</a><br>");
		while(rs.next()) {
			out.print("Module " + i + ": " + rs.getString(2) + "<br>");
			i = i + 1;
		}
	}
	
%>
	<!--out.print("<form action='coursepage?course_id="+rs.getInt(1)+"' method='post'><input type='submit' value='Enroll Now'></form>");-->


</body>
</html>