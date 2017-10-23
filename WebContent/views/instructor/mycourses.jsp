<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>Instructor Courses</h4><br>

<%
	ResultSet instructor_courses = (ResultSet)request.getAttribute("instructor_courses");
	
	out.print("Name: " + instructor_courses.getString(2) + "<br>");
	out.print("Description: " + instructor_courses.getString(3) + "<br>");

	while(instructor_courses.next()) {
		out.print("Name: " + instructor_courses.getString(2) + "<br>");
		out.print("Description: " + instructor_courses.getString(3) + "<br>");
	}
%>
<!-- out.print("<a href='coursepage?course_id="+course.getInt(1)+"'>Go to course</a><br>"); -->
</body>
</html>