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
<title>List courses</title>
</head>
<body>

<table>
	<tr>
		<th>Name</th>
		<th>Code</th>
		<th>Start date</th>
		<th>Teacher id</th>
	</tr>

<c:forEach items="${courselist}" var="course">
	<tr>
		<td><a href="Viewcourse?courseid=${course.getId()}">
		<c:out value="${course.getName()}"/></a></td>
		<td><c:out value="${course.getCode()}"/></td>
		<td><fmt:formatDate value="${course.getDate()}" pattern="yyyy-MM-dd"/></td>
		<td><c:out value="${course.getTeacher().getName()}"/></td>
	</tr>
</c:forEach>
</table>


</body>
</l:layout>