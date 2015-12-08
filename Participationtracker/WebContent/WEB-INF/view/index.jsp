<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/Login" method="POST">
<table>
<tr>
<th>Name</th>
<th>Uid</th>
<th>Email</th>
<th>Role</th>
</tr>
<tr>

<td><%= request.getAttribute( "name" ) %></td>
<td><%= request.getAttribute( "uuid" ) %></td>
<td><%= request.getAttribute( "email" ) %></td>
<td><%= request.getAttribute( "role" ) %></td>
</tr>

</table>
</form>
</body>
</html>