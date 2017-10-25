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
		
		<%
			ResultSet enrolled = (ResultSet)request.getAttribute("enrolled");
			String message = (String)request.getAttribute("message");
			
			if(message == "") {
				while(enrolled.next()) {
					out.print("<a href=''>"+enrolled.getString(4)+"</a>");
					out.print(enrolled.getString(1) + " " + enrolled.getString(2));
					out.print(enrolled.getString(3));
				}	
			}
			else {
				out.print(message);
			}
		%>
	</center>
	
</body>
</html>