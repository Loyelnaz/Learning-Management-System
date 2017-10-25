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
	
	<form action="" method="post">
	<%
		ResultSet quiz = (ResultSet)request.getAttribute("quizes");
	
		while(quiz.next()) {
			out.print(quiz.getString(9) + ". ");
			out.print(quiz.getString(3) + "<br>");
			out.print("<input type='radio' name='option1'> " + quiz.getString(4) + "<br>");
			out.print("<input type='radio' name='option1'> " + quiz.getString(5) + "<br>");
			out.print("<input type='radio' name='option1'> " + quiz.getString(6) + "<br>");
			out.print("<input type='radio' name='option1'> " + quiz.getString(7) + "<br>");
		}
	%>
	</form>

</body>
</html>