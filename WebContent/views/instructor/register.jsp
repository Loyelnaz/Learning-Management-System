<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" type="text/css">
<title>Instructor Registration Page</title>
</head>
<body>

<center style="margin-top: 100px;margin-left:60px;margin-bottom:30px"><h4>Instructor Registration</h4></center>

<form action="register" method="post">
	<center>
		<label>First Name: </label><input type="text" name="first_name"><br>
		<label>Middle Name: </label><input type="text" name="middle_name"><br>
		<label>Last Name: </label><input type="text" name="last_name"><br>
		<label>Email ID: </label><input type="text" name="emailid"><br>
		<label>Phone No: </label><input type="text" name="phoneno"><br>
		<label>User Name: </label><input type="text" name="username"><br>
		<label>Password: </label><input type="password" name="password"><br>
		<input type="submit" value="Register" class="btn btn-primary">
	</center>
</form>

<center style="margin-left:70px;margin-top:30px">
Have an account?<a href="login.jsp"> Login</a>
</center>

</body>
</html>