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
	
	<form action="quizresult" method="post">
	<%
		int module_no = (Integer)request.getAttribute("module_no");
		int course_id = (Integer)request.getAttribute("course_id");
		
		ResultSet quiz = (ResultSet)request.getAttribute("quizes");
	
		while(quiz.next()) {
			out.print(quiz.getInt(9) + ". ");
			out.print(quiz.getString(3) + "<br>");
			out.print("<input type='radio' name='option1"+quiz.getInt(9)+"' value='"+quiz.getString(4)+"'> " + quiz.getString(4) + "<br>");
			out.print("<input type='radio' name='option2"+quiz.getInt(9)+"' value='"+quiz.getString(5)+"'> " + quiz.getString(5) + "<br>");
			out.print("<input type='radio' name='option2"+quiz.getInt(9)+"' value='"+quiz.getString(6)+"'> " + quiz.getString(6) + "<br>");
			out.print("<input type='radio' name='option3"+quiz.getInt(9)+"' value='"+quiz.getString(7)+"'> " + quiz.getString(7) + "<br>");
		}
		out.print("<input type='hidden' value='"+module_no+"' name='module_no'>");
		out.print("<input type='hidden' value='"+course_id+"' name='course_id'>");
		out.print("<input type='submit' value='Submit' class='btn btn-primary'>");
	%>
	</form>

</body>
</html>