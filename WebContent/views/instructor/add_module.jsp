<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int course_id = (int) request.getAttribute("course_id");
	System.out.println("JSP Course ID: " + course_id);
%>

<form action="add_module" method="post">
	Module Name: <input type="text" name="module_name">
	Module Description: <textarea rows="4" cols="20" name="description"></textarea>
	<input type="hidden" name="course_id" value=<%=course_id %>>
	<input type="submit" value="Add Module">
</form>

</body>
</html>