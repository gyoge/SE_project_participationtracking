<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<l:layout>
<head>
<title>Register</title>
</head>
<body>
<form action="Register" method="POST">

<div>
<label>Name</label>
<input type="text" name="name" value="Gergely Gy�rki">
</div>

<div>
<label>Uuid</label>
<input type="text" name="uuid" value="e1100625">
</div>

<div>
<label>Email</label>
<input type="text" name="email" value="e1100625@edu.vamk.fi">
</div>

<div>
<label>Password</label>
<input type="password" name="password">
</div>

<div>
<label>Password again</label>
<input type="password" name="password_again">
</div>

<div>
<label>Address</label>
<input type="text" name="address" value="e11">
</div>

<div>
<label>Phone number</label>
<input type="text" name="phonenum" value="1234">
</div>

<input type="submit" value="Submit">

</form>
</body>
</l:layout>