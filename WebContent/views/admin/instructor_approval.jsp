<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="controller.admin.InstructorApprovalController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hi Instructor Approval page!
	
	<%
		ResultSet inactive_instructor = (ResultSet) request.getAttribute("inactive");
	
		while(inactive_instructor.next()) {
			out.print(inactive_instructor.getString(2));
		}
		out.print("<form action='instructor_approval' method='post'><input type='submit' value='Approve'></input></form>");
	%>
	<!--out.print("<a href='instructor_approval'>Approve</a>");-->
</body>
</html>