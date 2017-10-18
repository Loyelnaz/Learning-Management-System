<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.util.*" %>
    <%@page language="java" import="java.sql.*" %>
    <%@page language="java" import="database.*" %>
    <%@page language="java" import="javax.servlet.http.HttpSession" %>
    <%@page import="java.util.*" %>
    <%@page import="controller.student.CourseListController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>

<h3>Hello ${requestScope.person}</h3>
<a href="profile.jsp">Profile</a><br>
<h4>Courses</h4>
<%
	ResultSet rs1 = (ResultSet)request.getAttribute("rs");
	while(rs1.next()) {
		out.print("Name: "+rs1.getString(2));
	}
%>

</body>
</html>