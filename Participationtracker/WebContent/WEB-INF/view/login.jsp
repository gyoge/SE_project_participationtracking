<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<l:layout>
<head>
<title>Login</title>
</head>
<body>
<div>
<form action="Login" method="POST">
	<div>
	<div><label for="userid">User ID:</label></div>
	<div><input name="userid" type="text"></div>
	</div>
	<div>
	<div><label for="password">Password</label></div>
	<div><input name="password" type="password"></div>
	</div>
	<input type="submit" value="Login"/>
</form>
	<div>Not registered yet? Click <a href="Register">here</a></div>
</div>
</body>
</html>
</l:layout>