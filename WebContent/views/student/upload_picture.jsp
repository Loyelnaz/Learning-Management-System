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

<h4>Upload Profile Picture</h4>

<form action="upload_picture" method="post" enctype="multipart/form-data">
	<input type="file" name="photo"><br>
	<input type="submit" value="Upload Picture">
</form>
</body>
</html>