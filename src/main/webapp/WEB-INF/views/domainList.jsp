<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Homepage</title>
</head>
<body>
	<c:forEach var="domain" items="${domains}" >
		<a href="<%= request.getContextPath() %>/getDomain?domainId=${domain.id }"><c:out value="${domain.domainName }"></c:out></a><br/>
	</c:forEach>
</body>
</html>