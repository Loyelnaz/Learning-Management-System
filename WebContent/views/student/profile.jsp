<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*" %>
    <%@page language="java" import="database.*" %>
    <%@page language="java" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Profile</h4>
<% 
HttpSession httpsession = request.getSession(true);
int user_id = (Integer) httpsession.getAttribute("user_id");
%>

<%
Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;

conn = new DBConnector().getConnection();
ps = conn.prepareStatement("select * from user_table where uid=?");
ps.setInt(1, user_id);
rs = ps.executeQuery();

if(rs.next()) {
	out.print("<label>First Name: "+rs.getString(2)+"</label><br>");
	out.print("<label>Middle Name: "+rs.getString(3)+"</label><br>");
	out.print("<label>Last Name: "+rs.getString(4)+"</label><br>");
	out.print("<label>Email ID: "+rs.getString(5)+"</label><br>");
	out.print("<label>Phone No: "+rs.getString(6)+"</label><br>");
	out.print("<label>User Name: "+rs.getString(7)+"</label><br>");
}
%>
</body>
</html>