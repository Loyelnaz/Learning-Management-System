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
	
	<table style="border: 1px solid black">
	<tr>
		<th>First Name</th>
		<th>Middle Name</th>
		<th>Last Name</th>
		<th>Email ID</th>
		<th>Phone No</th>
		<th>User Name</th>
		<th>Status</th>
	</tr>
	<%
		ResultSet inactive_instructor = (ResultSet) request.getAttribute("inactive");
		
		while(inactive_instructor.next()) {
			out.print("<tr>");
			out.print("<td>" + inactive_instructor.getString(2) + "</td>");
			out.print("<td>" + inactive_instructor.getString(3) + "</td>");
			out.print("<td>" + inactive_instructor.getString(4) + "</td>");
			out.print("<td>" + inactive_instructor.getString(5) + "</td>");
			out.print("<td>" + inactive_instructor.getString(6) + "</td>");
			out.print("<td>" + inactive_instructor.getString(6) + "</td>");
			int uid = inactive_instructor.getInt(1);
			out.print("<td><a href='approve?uid='"+uid+"''>Approve</a></td>");
			out.print("</tr>");
		}
	%>
	</table>
	<!--out.print("<form action='instructor_approval?uid=' method='post'><input type='submit' value='Approve'></input></form>");-->
</body>
</html>