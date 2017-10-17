<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Page</title>
</head>
<body>

<form action="register" method="post">
	<label>First Name: </label><input type="text" name="first_name"><br>
	<label>Middle Name: </label><input type="text" name="middle_name"><br>
	<label>Last Name: </label><input type="text" name="last_name"><br>
	<label>Email ID: </label><input type="text" name="emailid"><br>
	<label>Phone No: </label><input type="text" name="phoneno"><br>
	<label>User Name: </label><input type="text" name="username"><br>
	<label>Password: </label><input type="password" name="password"><br>
	<input type="submit" value="Register">
</form>

</body>
</html>