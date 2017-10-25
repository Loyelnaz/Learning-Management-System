<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>My Courses</title>
</head>
<body>

<%@include file="link.jsp"%>

<h4 style="margin-top:20px">Instructor Courses</h4><br>

<%
	ResultSet instructor_courses = (ResultSet)request.getAttribute("instructor_courses");
	String status = (String)request.getAttribute("status");
	
	if(status.equals("")) {
		while(instructor_courses.next()) {
			out.print("<h5>" + instructor_courses.getString(2) + "</h5>");
			out.print("<i>" + instructor_courses.getString(3) + "</i><br>");
			out.print("<a href='editcourse?course_id="+instructor_courses.getString(1)+"'>Edit Course</a>");
		}		
	}
	else {
		out.print(status);
	}

%>
<!-- out.print("<a href='coursepage?course_id="+course.getInt(1)+"'>Go to course</a><br>"); -->
</body>
</html>