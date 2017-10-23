<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Insert title here</title>
</head>
<body>

<%@include file="link.jsp"%>

<%
	int course_id = (int) request.getAttribute("course_id");
	System.out.println("JSP Course ID: " + course_id);
%>

<center style="margin-top:40px">
<h4>Add Module</h4>
<form action="add_module" method="post">
	Module Name: <input type="text" name="module_name" style="margin-left:35px;margin-bottom:10px">
	Module Description: <textarea rows="4" cols="20" name="description" style="margin-bottom:10px"></textarea>
	<input type="hidden" name="course_id" value=<%=course_id %>>
	<input type="submit" value="Add Module" class="btn btn-primary" style="margin-top:30px">
</form>
</center>

</body>
</html>