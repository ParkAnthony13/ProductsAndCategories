<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h1>New Category</h1>
			<form:form action="/categories/new" method="post" modelAttribute="category">
			    <p>
			        <form:label path="name">Category Name</form:label>
			        <form:errors path="name" style="color:red;"/>
			        <form:input path="name" type="text"/>
			    </p>
			    <input type="submit" value="Create Category" class="btn btn-dark"/>
			</form:form>
			<a href="/products/new">New Product</a>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<td>Name</td>
					</tr>	
				</thead>
					<c:forEach items="${categories}" var="cat">
					<tr>
						<td><a href="/categories/${cat.id}"><c:out value="${cat.name}" /></a></td>
					</tr>
					</c:forEach>
				<tbody>
				</tbody>
			</table>
		</div>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>