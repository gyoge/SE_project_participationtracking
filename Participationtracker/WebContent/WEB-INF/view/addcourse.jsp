<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Course"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<l:layout>

<head>
<title>New Course</title>
</head>
<body>

<h3><c:out value="New Course"/></h3>

<form action="Addcourse" method="POST">
<div>
<div><label>Name</label></div>
<div><input name="name" /></div>
</div>

<div>
<div><label>Code</label></div>
<div><input name="code"/></div>
</div>

<div>
<div><label>Start date</label></div>
<div><input name="date"/></div>
</div>

<div>
<div><label>Description</label></div>
<div><input name="description"/></div>
</div>

<input type="submit" value="Add course">
</form>
</body>
</l:layout>