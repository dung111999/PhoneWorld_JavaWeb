<%@page import="com.model.Brand"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/client/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/client/css/bootstrap.css">

</head>
<body class="animsition">
	<div class="container">
		<div col-md-12>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand"
							href="${pageContext.request.contextPath }/home"
							style="color: pink">PhoneWorld</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath }/cart/list"><span
								class="glyphicon glyphicon-cart"></span> Gio Hang</a></li>
					</ul>
				</div>
			</nav>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath }/home" method="post">
			<div class="container col-md-12">
				<div class="col-md-10">
					<input name="name" type="text" class="form-control"
						placeholder="Tim kiem ten...">
				</div>
				<div>
					<button type="submit" class="btn btn-default">Search</button>
				</div>
			</div>
		</form>

		<div class="list-group col-md-2">
			<h4>Brand</h4>
			<c:forEach items="${brands}" var="brand">
				<a href="${pageContext.request.contextPath }/home/brand?brandname=${brand.brand }"
					class="list-group-item">${brand.brand}</a>
			</c:forEach>
		</div>

		<div class="row text-center col-md-9" style="padding-top: 40px">
			<c:forEach items="${products }" var="product">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="${pageContext.request.contextPath }/product/download?filename=${product.image }"
							style="width: 225px; height: 225px"> <a
							href="${pageContext.request.contextPath }/detail?id=${product.id }"> <strong>${product.productName }</strong>
						</a>
						<p>${product.price }</p>
						<a href="${pageContext.request.contextPath }/add-to-cart?productId=${product.id }"><button
								class="btn">Add to cart</button></a>
					</div>
				</div>
			</c:forEach>

		</div>

	</div>

</body>
</html>