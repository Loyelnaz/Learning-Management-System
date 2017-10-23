<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="link.jsp"%>

<center style="margin-top:20px">
<h4>Add instructor</h4>

<form action="add_instructor" method="post">
	<label>First Name: </label><input type="text" name="first_name"><br>
	<label>Middle Name: </label><input type="text" name="middle_name"><br>
	<label>Last Name: </label><input type="text" name="last_name"><br>
	<label>Email ID: </label><input type="text" name="emailid"><br>
	<label>Phone No: </label><input type="text" name="phoneno"><br>
	<label>User Name: </label><input type="text" name="username"><br>
	<label>Password: </label><input type="password" name="password"><br>
	<input type="submit" value="Add Instructor" class="btn btn-primary">
</form>
</center>

</body>
</html>