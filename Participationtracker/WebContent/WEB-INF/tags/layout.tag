<%@tag description="layout" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <body>
    <div id="pageheader">
    <c:if test="${not empty LOGIN_USER}">
	    <a href="Listcourse">List Course</a>
	    Greetings, ${LOGIN_USER.name}
    </c:if>
      <jsp:invoke fragment="header"/>
    </div>
    <div id="body">
   	  <div id="errorlist">
   	  	<ul>
   	  	<c:forEach items="${errorlist}" var="error">
			<li>
				<c:out value="${error}" />
			</li>
		</c:forEach>
   	  	</ul>
   	  </div>
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
 		
      <jsp:invoke fragment="footer"/>
    </div>
  </body>
</html>