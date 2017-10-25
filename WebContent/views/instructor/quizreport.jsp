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
	
	<%
		ResultSet quiz_report = (ResultSet)request.getAttribute("quiz_report");
		String message = (String)request.getAttribute("message");
		
		if(message == "") {
			while(quiz_report.next()) {
				out.print("<b>Module " + quiz_report.getInt(2) + "</b>: " + quiz_report.getString(3) + "<br>");
				out.print("Score: " + quiz_report.getInt(1));
			}
		}
		else {
			
		}
	%>
	
</body>
</html>