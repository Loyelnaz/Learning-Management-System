<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>

<%@include file="link.jsp"%>

<h4>Courses</h4>
<%
	ResultSet course = (ResultSet)request.getAttribute("courses");
	while(course.next()) {
		out.print("Name: " + course.getString(2) + "<br>");
		out.print("Description: " + course.getString(3) + "<br>");
		out.print("<a href='coursepage?course_id="+course.getInt(1)+"'>Go to course</a><br>");
	}
%>

</body>
</html>