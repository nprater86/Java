<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create License</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<form:form action="/licenses" method="post" modelAttribute="license">
		<div class="mb-3">
			<form:label path="person">Person</form:label>
			<select name="person">
				<c:forEach var="person" items="${persons}">
					<option value="${person.id}"><c:out value="${person.firstName }" /> <c:out value="${person.lastName }" /></option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<form:label path="state">State</form:label>
			<form:input path="state" />
			<form:errors class="text-danger" path="state" />
		</div>
		<div class="mb-3">
			<form:label path="expirationDate">Expiration Date</form:label>
			<form:input type="date" path="expirationDate" />
			<form:errors class="text-danger" path="expirationDate" />
		</div>
		<input type="submit" class="btn btn-primary" value="Submit" />
	</form:form>
</body>
</html>