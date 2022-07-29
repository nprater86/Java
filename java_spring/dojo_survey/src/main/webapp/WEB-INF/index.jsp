<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container m-auto d-flex justify-content-center">
		<form class="border rounded p-3 mt-5 w-50" method="post" action="/submitSurvey">
			<div class="row justify-content-between mb-3">
				<div class="col-4">
					<label class="col-form-label">Your Name:</label>
				</div>
				<div class="col-6">
					<input type="text" name="name" class="form-control">
					<p class="text-danger"><small>${nameError}</small></p>
				</div>
			</div>
			<div class="row justify-content-between mb-3">
				<div class="col-4">
					<label class="col-form-label">Dojo Location:</label>
				</div>
				<div class="col-6">
					<select name="location" class="form-select">
						<option value="Bellvue, WA">Bellevuew, WA</option>
						<option value="Chicago, IL">Chicago, IL</option>
						<option value="Los Angelas, CA">Los Angelas, CA</option>
						<option value="Silicon Valley, CA">Silicon Valley, CA</option>
					</select>
					<p class="text-danger"><small>${locationError}</small></p>
				</div>
			</div>
			<div class="row justify-content-between mb-3">
				<div class="col-4">
					<label class="col-form-label">Favorite Language:</label>
				</div>
				<div class="col-6">
					<select name="language" class="form-select">
						<option value="JavaScript">JavaScript</option>
						<option value="Python">Python</option>
						<option value="C#">C#</option>
						<option value="Java">Java</option>
					</select>
					<p class="text-danger"><small>${languageError}</small></p>
				</div>
			</div>
			<div class="row mb-3">
				<label class="form-label mb-3">Comment:</label>
				<textarea class="form-control" name="comment" rows="4" style="resize: none;"></textarea>
			</div>
			<div class="row justify-content-end">
				<div class="col-auto">
					<input type="submit" class="btn btn-secondary">
				</div>
			</div>
		</form>
	</div>
</body>
</html>