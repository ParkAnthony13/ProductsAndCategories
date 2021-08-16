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
			<h1>New Product</h1>
			<form:form action="/products/new" method="post" modelAttribute="product">
			    <p>
			        <form:label path="name">Product Name</form:label>
			        <form:errors path="name" style="color:red;"/>
			        <form:input path="name" type="text"/>
			    </p>
			    <p class="d-flex">
			        <form:label path="description">Product Description</form:label>
			        <form:errors path="description" style="color:red;"/>
			        <form:textarea path="description" type="text"></form:textarea>
			    </p>
			    <p>
			        <form:label path="price">Product Price</form:label>
			        <form:errors path="price" style="color:red;"/>
			        <form:input path="price" type="number"/>
			    </p>
			    <input type="submit" value="Create Product" class="btn btn-dark"/>
			</form:form>
			<a href="/categories/new">New Category</a>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<td>Name</td>
						<td>Description</td>
						<td>Price</td>
					</tr>	
				</thead>
					<c:forEach items="${products}" var="prod">
					<tr>
						<td><a href="/products/${prod.id}"><c:out value="${prod.name}" /></a></td>
						<td><c:out value="${prod.description}" /></td>
						<td>$<c:out value="${prod.price}" /></td>
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