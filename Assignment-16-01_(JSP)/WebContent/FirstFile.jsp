<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="a" value="${1}"></c:set>
<c:if test="${a == 1 }"> hello world</c:if>
<c:choose>
	<c:when test="${a==1}">foo</c:when>
	<c:when test="${a==3}">bar</c:when>
	<c:otherwise>bob</c:otherwise>
</c:choose>
<h1>hello world</h1>
<%!
	int var = 25;
	int getAge() {
		return var;
	}
%>
<h1>My age is <%=getAge() %></h1>

<form action="SecondFile.jsp" method="post">
	<input type="text" name="name" placeholder = "name"/>
	<input type="submit"/>
</form>
</body>
</html>