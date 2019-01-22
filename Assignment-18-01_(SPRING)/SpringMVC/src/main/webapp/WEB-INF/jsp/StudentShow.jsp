<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>List of Students</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Student id</th>
		<th>Student name</th>
		<th>Student gender</th>
		<th>Student age</th>

	</tr>
	<c:forEach var="student" items="${students}">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.studentName}</td>
			<td>${student.studentGender}</td>
			<td>${student.studentAge}</td>
			<!-- <td><a href="editemp/${emp.id}">Edit</a></td>  -->
			<!-- <td><a href="deleteemp/${emp.id}">Delete</a></td> -->
		</tr>
	</c:forEach>
</table>
<br />
<a href="new">Add New Student</a>
