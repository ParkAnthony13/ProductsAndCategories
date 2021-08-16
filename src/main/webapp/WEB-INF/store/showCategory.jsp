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
			<h1><c:out value="${category.name}"/></h1>
			<table class="table">
				<thead>
					<tr>
						<td>Product Name</td>
						<td>Product Description</td>
						<td>Product Price</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
					<tr>
						<td><c:out value="${product.name}"/></td>
						<td><c:out value="${product.description}"/></td>
						<td><c:out value="${product.price}"/></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<form action="/categories/${category.id}" method="post">
					<select name="products">
						<c:forEach items="${notInCatProductList}" var="prod">
							<option value="${prod.id}"><c:out value="${prod.name}"/></option>
						</c:forEach>
					</select>
					<button class="btn btn-warning">Add Product to Category</button>
				</form>
			</div>
			<a href="/categories/new">Category Home</a>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>