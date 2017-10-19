<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
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
	%>
</body>
</html>