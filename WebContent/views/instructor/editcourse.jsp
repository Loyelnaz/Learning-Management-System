<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Edit Course - Instructor</title>
</head>
<body>

	<%@include file="link.jsp"%>
	
	<%
		ResultSet edit_course = (ResultSet)request.getAttribute("edit_courses");
		
		if(edit_course.next()) {
	%>
	<center>
		<h4 style="margin-top: 15px">Edit Course</h4>
		<form action="editcourse" method="post" style="margin-top:30px;">
			<label>Course Name:</label><input type="text" value="<%=edit_course.getString("course_name")%>" name="course_name"><br>
			<label>Course Description:</label><textarea cols="40" rows="3" name="course_description"><%=edit_course.getString("course_description")%></textarea><br>
			<input type="hidden" name="course_id" value=<%=edit_course.getInt(1) %>>
			<input type="submit" value="Save Course" class="btn btn-primary" style="margin-top:15px">
		</form>
	</center>
	<%} %>
</body>
</html>