<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="link.jsp"%>

<h4>My Courses</h4>

<%
ResultSet course = (ResultSet)request.getAttribute("user_courses");

while(course.next()) {
	out.print("<h5>" + course.getString(2) + "</h5>");
	out.print("<i>" + course.getString(3) + "<i><br>");
	out.print("<a href='coursepage?course_id="+course.getInt(1)+"'>Go to course</a><br><br>");
}
%>

<!-- out.print("Name: " + my_course.getString(2) + "<br>");
	out.print("Description: " + my_course.getString(3) + "<br>");
	out.print("<a href='coursepage?course_id="+my_course.getInt(1)+"'>Go to course</a><br>"); -->
</body>
</html>