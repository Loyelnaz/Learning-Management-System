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
<body style="margin-left: 50px">

	<%@include file="link.jsp"%>
	
	<%
		ResultSet quiz_result = (ResultSet)request.getAttribute("quiz_result");
		if(quiz_result.next()) {
	%>
	
	<center style="margin-top: 100px">
		<h4>Quiz Result</h4>
		
		You Scored: <%=quiz_result.getInt(1) %><br>
		Maximum Score: <%=quiz_result.getInt(2) %><br>
		Percentage: <% out.print(String.format("%.2f", (float)quiz_result.getInt(1) / quiz_result.getInt(2) * 100)); %>%
	</center>
	<%} %>
</body>
</html>