<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>All Books</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${books}" var="book">
	        <tr>
	            <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
	            <td><c:out value="${book.description}"/></td>
	            <td><c:out value="${book.language}"/></td>
	            <td><c:out value="${book.numberOfPages}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/books/new">New Book</a>
</body>
</html>