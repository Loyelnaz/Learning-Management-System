<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*" %>
    <%@page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Add Course</title>
</head>
<body>

<%@include file="link.jsp"%>

<center style="margin-top:40px">
<h4>Add Course</h4>

<form action="add_course" method="post">
	Course Name: <input type="text" name="course_name" style="margin-left:35px;margin-bottom:10px"><br>
	Course Description: <textarea rows="4" cols="20" name="course_description" style="margin-bottom:10px"></textarea><br>
	Course Category: 
	<select name="category">
	<%
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet category = null;
		conn = new DBConnector().getConnection();
		
		ps = conn.prepareStatement("select * from course_category");
		category = ps.executeQuery();
		
		while(category.next()) {
			out.print("<option value='"+category.getInt(1)+"'>"+category.getString(2)+"</option><br>");
		}
	%>
	</select>
	<br>
	<input type="submit" value="Add Course" class="btn btn-primary" style="margin-top:30px">
</form>
</center>
</body>
</html>