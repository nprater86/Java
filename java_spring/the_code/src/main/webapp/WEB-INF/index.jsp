<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container m-auto text-center">
		<div class="mt-5 d-flex flex-column align-items-center">
			<p class="text-danger">${error}</p>
			<h1 class="display-6">What is the code?</h1>
			<form class="mt-3 w-25" method="post" action="/submit">
				<input type="text" name="code" class="form-control">
				<input type="submit" class="btn btn-primary mt-3" value="Try Code">
			</form>
		</div>
	</div>
</body>
</html>