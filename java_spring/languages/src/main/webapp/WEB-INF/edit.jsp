<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="mt-5 d-flex justify-content-end align-items-center gap-3">
		<form class="d-inline" action="/languages/${language.id }" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" class="btn btn-link" value="Delete">
		</form>
		<a href="/languages">Dashboard</a>
	</div>
	<form:form class="mt-3" action="/languages/edit/${language.id}" method="put" modelAttribute="language">
		<div class="row mb-3">
			<div class="col-4">
				<form:label class="col-form-label" path="name">Name</form:label>
			</div>
			<div class="col-4">
				<form:input class="form-control" path="name"/>
				<small><form:errors class="text-danger" path="name"/></small>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-4">
				<form:label class="col-form-label" path="creator">Creator</form:label>
			</div>
			<div class="col-4">
				<form:input class="form-control" path="creator"/>
				<small><form:errors class="text-danger" path="creator"/></small>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-4">
				<form:label class="col-form-label" path="version">Version</form:label>
			</div>
			<div class="col-4">
				<form:input class="form-control" path="version"/>
				<small><form:errors class="text-danger" path="version"/></small>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-auto">
				<input class="btn btn-secondary" type="submit" value="Submit"/>
			</div>
		</div>
	</form:form>
</div>
</body>
</html>