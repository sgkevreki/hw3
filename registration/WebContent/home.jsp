<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
table#nat{
	width: 50%;
}
</style>
</head>
<body>  
<% 
	String name =  request.getParameter("fullname");
	String userName = request.getParameter("userName");
	String pass = request.getParameter("pass");
	String age = request.getParameter("age");
%>
<table id ="nat">
<tr>
	<td>Full Name</td>
	<td><%= name %></td>
</tr>
<tr>
	<td>User Name</td>
	<td><%= userName %></td>
</tr>
<tr>
	<td>Age</td>
	<td><%= age %></td>
</tr>
</table>

<br>



</body>
</html>