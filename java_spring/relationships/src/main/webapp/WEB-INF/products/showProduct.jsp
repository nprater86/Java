<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
	<h1 class="display-4"><c:out value="${product.name }"/></h1>
	<p><c:out value="${product.description }"/></p>
	<div class="row">
		<div class="col-6">
			<h1 class="dispaly-6">Categories:</h1>
			<ul>
				<c:forEach items="${product.categories }" var="category">
					<li><c:out value="${category.name }" /></li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-6">
			<form action="/products/addCategory" method="post">
				<input type="hidden" name="product_id" value="${product.id }"/>
				<label>Add Category</label>
				<select name="category_id">
					<c:forEach items="${notCategories }" var="category">
						<option value="${category.id }"><c:out value="${category.name }"/></option>
					</c:forEach>
				</select>
				<input type="submit" class="btn btn-primary mt-3" value="Submit" />
			</form>
		</div>
	</div>
</div>
</body>
</html>