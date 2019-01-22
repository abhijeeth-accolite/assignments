<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
	<form:form action="create" modelAttribute="student" method="POST">  
        student name: <form:input path="studentName" />
		<br>  
        student gender:   
        Male<form:radiobutton path="studentGender" value="Male" />  
        Female<form:radiobutton path="studentGender" value="Female" />
		<br>
        student age: <form:input type="number" path="studentAge"/>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>

