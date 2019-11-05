<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px red;
	margin: 0px
}
</style>
<body>
	<h1>Registration Form</h1>
	<div class="ex">
		<form action="RegistrationController" method="post">
			<table style="with: 70%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" /></td>
				</tr>
			</table>
			<input type="submit" value="register" />
		</form>
		<br>
	
		
	</div>
</body>
</html>