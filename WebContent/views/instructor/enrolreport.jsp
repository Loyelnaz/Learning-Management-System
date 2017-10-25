<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Insert title here</title>
</head>
<body>

	<%@include file="link.jsp"%>
	
	<center style="margin-top: 40px">
		<h4>Enrolled Students</h4>
		
		<table style="border-collapse: collapse;">
			<tr>
				<th style="border: 1px solid black">User Name</th>
				<th style="border: 1px solid black">Name</th>
				<th style="border: 1px solid black">Email ID</th>
			</tr>
			<%
				ResultSet enrolled = (ResultSet)request.getAttribute("enrolled");
				String message = (String)request.getAttribute("message");
				
				if(message == "") {
					while(enrolled.next()) {
						out.print("<tr>");
						out.print("<td align='center' style='border: 1px solid black'><a href='quizscore?username="+enrolled.getString(4)+"'>"+enrolled.getString(4)+"</a></td>");
						out.print("<td align='center' style='border: 1px solid black'>" + enrolled.getString(1) + " " + enrolled.getString(2) + "</td>");
						out.print("<td align='center' style='border: 1px solid black'>" + enrolled.getString(3) + "</td>");
						out.print("</tr>");
					}	
				}
				else {
					out.print(message);
				}
			%>
		</table>
	</center>
	
</body>
</html>