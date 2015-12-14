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
<title>${course.name}</title>
</head>
<body>

<h3><c:out value="${course.getName()}"/></h3>

<div>
<div><label>Code</label></div>
<div><c:out value="${course.getCode()}"/></div>
</div>

<div>
<div><label>Start date</label></div>
<div><fmt:formatDate value="${course.getDate()}" pattern="yyyy-MM-dd"/></div>
</div>

<div>
<div><label>Description</label></div>
<div><c:out value="${course.getDescription()}"/></div>
</div>
<div>
<div><label>Teacher</label></div>
<div><c:out value="${course.getTeacher().getName()}"/></div>
</div>

<hr/>
<h3>Sessions</h3>
<table>
	<tr>
		<th>Date</th>
		<th>Description</th>
	</tr>

<c:forEach items="${sessionlist}" var="session">
	<tr>
		<td><fmt:formatDate value="${session.getDate()}" pattern="yyyy-MM-dd"/></td>
		<td><c:out value="${session.getDescription()}"/></td>
	</tr>
</c:forEach>
</table>


</body>
</l:layout>