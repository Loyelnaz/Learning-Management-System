<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Instructor Login Page</title>
</head>
<body>

<a href="/LMS">Home</a>

<center><h4 style="margin-top: 120px;margin-bottom:30px">Instructor Login</h4>

<form action="login" method="post">
	
	<%
		String message = (String)request.getAttribute("error");
		if(message != null) 
			out.print("<font color='red'>" + message + "</font><br>");
	%>
	<label>Username: </label><input type="text" name="username"><br>
	<label>Password: </label><input type="password" name="password"><br>
	<input type="submit" value="Login" class="btn btn-primary"><br>

</form>
</center>

<center style="margin-top:20px">Don't have an account?<a href="register.jsp"> Register</a></center>

</body>
</html>