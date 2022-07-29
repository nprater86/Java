<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container m-auto d-flex justify-content-center">
		<div class="w-50 border rounded mt-5 p-3">
			<p>Name: <c:out value="${name}"/></p>
			<p>Location: <c:out value="${location}"/></p>
			<p>Favorite Language: <c:out value="${language}"/></p>
			<p>Comment: <c:out value="${comment}"/></p>
		</div>
	</div>
</body>
</html>