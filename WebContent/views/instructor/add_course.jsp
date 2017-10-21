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
<h4>Add Course</h4>
<form action="add_course" method="post">
	Course Name: <input type="text" name="course_name"><br>
	Course Description: <textarea rows="4" cols="20" name="course_description"></textarea>
	<select name="category">
	<%
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet category = null;
		conn = new DBConnector().getConnection();
		
		ps = conn.prepareStatement("select * from course_category");
		category = ps.executeQuery();
		
		while(category.next()) {
			out.print("<option value='"+category.getInt(1)+"'>"+category.getString(2)+"</option>");
		}
	%>
	</select>

	<input type="submit" value="Add Course">
</form>
</body>
</html>