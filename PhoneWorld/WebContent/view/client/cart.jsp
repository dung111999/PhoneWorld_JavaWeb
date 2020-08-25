<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gio Hang</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/client/css/bootstrap.css">

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
		<div class="col-md-10">
			<h4 style="display: block">
				Gio hang
				</h2>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>Ma san pham</th>
							<th>Ten san pham</th>
							<th>Anh san pham</th>
							<th>Gia</th>
							<th>So luong</th>
							<th>Thanh tien</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cart}" var="map">
							<tr>
								<td>${map.value.product.id }</td>
								<td>${map.value.product.productName }</td>
								<td><img
									src="${pageContext.request.contextPath }/product/download?filename=${map.value.product.image }"
									style="width: 50px; height: 50px"></td>
								<td>${map.value.product.price}</td>
								<td>
									<form action="${pageContext.request.contextPath }/update-cart-item">
										<input type="hidden" name="key" value="${map.key }"> <input
											type="text" name="quantity" value="${map.value.quantity }">
										<button type="submit">Update</button>
									</form>
								</td>
								<td>${map.value.product.price * map.value.quantity}</td>
								<td><a href="${pageContext.request.contextPath }/remove-cart-item?key=${map.key}">Delete</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		<div class="col-md-2" style="float: right;">
			<h4>Total</h4>
			<div class="total">${sum }</div>
			<a href="${pageContext.request.contextPath }/client/checkout"><button class="btn">Thanh
					Toan</button></a>
		</div>

	</div>

</body>
</html>