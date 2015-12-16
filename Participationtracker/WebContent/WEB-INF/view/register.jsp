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
	<div>
	<label>Name</label>
	</div>
	<div>
	<input type="text" name="name"/>
	</div>
</div>

<div>
<div><label>Uuid</label></div>
<div><input type="text" name="uuid"/></div>
</div>

<div>
<div><label>Email</label></div>
<div><input type="text" name="email"/></div>
</div>

<div>
<div><label>Password</label></div>
<div><input type="password" name="password" />Currently the password system is not secure yet! Please do not provide your everyday used password!</div>
</div>

<div>
<div><label>Password again</label></div>
<div><input type="password" name="password_again" /></div>
</div>

<div>
<div><label>Address</label></div>
<div><input type="text" name="address" /></div>
</div>

<div>
<div><label>Phone number</label></div>
<div><input type="text" name="phonenum"/></div>
</div>

<input type="submit" value="Submit" />

</form>
</body>
</l:layout>