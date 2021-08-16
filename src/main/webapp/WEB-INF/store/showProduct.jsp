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
			<h1><c:out value="${product.name}"/></h1>
			<div>
				<table class="table">
					<thead>
						<tr>
							<td>Categories</td>
						</tr>	
					</thead>
						<c:forEach items="${product.categories}" var="prodCat">
						<tr>
							<td><c:out value="${prodCat.name}" /></td>
						</tr>
						</c:forEach>
					<tbody>
					</tbody>
				</table>
				<div>
					<form action="/products/${product.id}" method="post">
						<select name="categories">
							<c:forEach items="${notProdCategories}" var="notProd">
								<option value="${notProd.id}">
									<c:out value="${notProd.name}"/>
								</option>			
							</c:forEach>
						</select>
						<button class="btn btn-primary">Add Category</button>
					</form>
					<a href="/products/new">Home</a>
				</div>
			</div>
		</div>

		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>