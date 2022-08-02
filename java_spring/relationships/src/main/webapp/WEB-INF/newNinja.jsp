<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<div class="mb-3">
			<form:label path="dojo">Dojo</form:label>
			<select name="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<option value="${dojo.id}"><c:out value="${dojo.name }" /></option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" />
			<form:errors class="text-danger" path="lastName" />
		</div>
		<div class="mb-3">
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" />
			<form:errors class="text-danger" path="lastName" />
		</div>
		<div class="mb-3">
			<form:label path="age">Age</form:label>
			<form:input type="number" path="age" />
			<form:errors class="text-danger" path="age" />
		</div>
		<input type="submit" class="btn btn-primary" value="Submit" />
	</form:form>
</div>
</body>
</html>