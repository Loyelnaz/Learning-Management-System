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
	
	<h4 style="margin-top:20px">Course Approval</h4>
	
	<%
		ResultSet inactive_course = (ResultSet)request.getAttribute("inactive");
	
		while(inactive_course.next()) {
			out.print("<h5>" + inactive_course.getString(2) + "</h5>");
			out.print("<i>" + inactive_course.getString(3) + "</i><br>");
			out.print("<a href='approve_course?course_id="+inactive_course.getInt(1)+"'>Approve</a><br><br>");
		}
	%>

</body>
</html>