<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css">
<title>Upload Image - Student</title>
</head>
<body>

<%@include file="link.jsp"%>

<center style="margin-top: 80px">
	<h4>Upload Profile Picture</h4>

	<form action="upload_picture" method="post" enctype="multipart/form-data">
		<input type="file" name="photo"><br>
		<input type="submit" value="Upload Picture" class="btn btn-primary">
	</form>
</center>

</body>
</html>