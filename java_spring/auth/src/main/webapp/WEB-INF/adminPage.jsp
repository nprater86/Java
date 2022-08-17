<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1>Welcome to the Admin Page <c:out value="${currentUser.username}"></c:out></h1>
	    
	    <table class="table table-striped">
	    	<thead>
	    		<tr>
		    		<th>User Name</th>
		    		<th>Action</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${allUsers }" var="user">
	    			<tr>
	    				<td><c:out value="${user.username }"/></td>
	    				<td>
	    					<c:if test="${user.isAdmin == true}">
	    						<p>Admin</p>
	    					</c:if>
	    					<c:if test="${user.isAdmin == false }">
		    						<form class="d-inline" action="/admin/delete/${user.id }" method="post">
		    							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    							<input type="submit" value="Delete" class="btn btn-danger"/>
		    						</form>
		    						<form class="d-inline" action="/admin/promote/${user.id }" method="post">
		    							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    							<input type="submit" value="Make Admin" class="btn btn-success"/>
		    						</form>
	    					</c:if>
	    				</td>
	    			</tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	</div>
</body>
</html>