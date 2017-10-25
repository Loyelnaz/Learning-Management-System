<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" type="text/css">
<title>Student Registration Page</title>
</head>
<body>

<center style="margin-top: 60px;margin-left:60px;margin-bottom:30px"><h4>Student Registration</h4></center>

<%
	String first_name = (String)request.getAttribute("first_name");
	String last_name = (String)request.getAttribute("last_name");
	String emailid = (String)request.getAttribute("emailid");
	String phoneno = (String)request.getAttribute("phoneno");
	String username = (String)request.getAttribute("username");
%>
<center>
<form action="register" method="post">
		<label>First Name: </label><input type="text" name="first_name">
		<% if(first_name != null) out.print("<br><font size='1px' color='red'>" + first_name + "</font>"); %><br>
		<label>Middle Name: </label><input type="text" name="middle_name"><br>
		<label>Last Name: </label><input type="text" name="last_name">
		<% if(last_name != null) out.print("<br><font size='1px' color='red'>" + last_name + "</font>"); %><br>
		<label>Email ID: </label><input type="text" name="emailid">
		<% if(emailid != null) out.print("<br><font size='1px' color='red'>" + emailid + "</font>"); %><br>
		<label>Phone No: </label><input type="text" name="phoneno">
		<% if(phoneno != null) out.print("<br><font size='1px' color='red'>" + phoneno + "</font>"); %><br>
		<label>User Name: </label><input type="text" name="username">
		<% if(username != null) out.print("<br><font size='1px' color='red'>" + username + "</font>"); %><br>
		<label>Password: </label><input type="password" name="password"><br>
		<input type="submit" value="Register" class="btn btn-primary">

</form>
</center>
<center style="margin-left:70px;margin-top:30px">
Have an account?<a href="login.jsp"> Login</a>
</center>

</body>
</html>