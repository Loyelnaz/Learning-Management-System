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

	<%@include file="link.jsp"%>
	
	<h4>Available Courses</h4>
	
	<%
		ResultSet active_course = (ResultSet)request.getAttribute("active");
		String not_active = (String)request.getAttribute("not_active");
		
		if(not_active.equals("")) {
			while(active_course.next()) {
				out.print("Name: " + active_course.getString(2) + "<br>");
				out.print("Description: " + active_course.getString(3) + "<br>");
			}		
		}
		else {
			out.print(not_active);
		}
	
	%>

</body>
</html>