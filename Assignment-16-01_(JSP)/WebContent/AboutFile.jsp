<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("username");
	try{
		
		int userCount = (int)session.getAttribute(username);
		session.setAttribute(username, userCount+1);
		
	} catch (NullPointerException e) {
		
		session.setAttribute(username, 1);
		
	}
	out.print(username + " has logged in "+session.getAttribute(username)+" times!");
%>
<br/><a href="LoginFile.jsp">go back to login</a>
</body>
</html>