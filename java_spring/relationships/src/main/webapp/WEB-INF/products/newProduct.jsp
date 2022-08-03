<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
	<form:form action="/products" method="post" modelAttribute="product">
		<div class="mb-3">
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<form:errors class="text-danger" path="name" />
		</div>
		<div class="mb-3">
			<form:label path="description">Description</form:label>
			<form:textarea path="description" />
			<form:errors class="text-danger" path="description" />
		</div>
		<div class="mb-3">
			<form:label path="price">Price</form:label>
			<input type="number" name="price" step="0.01" min="0.00" />
			<form:errors class="text-danger" path="price" />
		</div>
		<input type="submit" class="btn btn-primary" value="Submit" />
	</form:form>
</div>
</body>
</html>