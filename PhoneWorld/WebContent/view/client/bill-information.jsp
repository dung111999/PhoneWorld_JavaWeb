<%@page import="com.model.Brand"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Information</title>
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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/client/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/client/css/main.css">

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

		<div class="container">
			<div class="card">
				<div class="card-header">
					Invoice <strong>${date }</strong> <span class="float-right">
						<strong>Status:</strong> Pending
					</span>

				</div>
				<div class="card-body">
					<div class="row mb-4">
						<div class="col-sm-6">
							<h6 class="mb-3">From:</h6>
							<div>
								<strong>PhoneWorld Store</strong>
							</div>
							<div>Ha Noi</div>
							<div>232 Phung Hung, Ha Dong</div>
							<div>Email: dung2232@gmail.com</div>
							<div>Phone: 11311411</div>
						</div>

						<div class="col-sm-6">
							<h6 class="mb-3">To:</h6>
							<div>
								<strong>Buyer : ${fullName }</strong>
							</div>
							<div>Address: ${deliveryAddress }</div>
							<div>Phone: ${phoneOrder }</div>
						</div>
					</div>
					<div class="table-responsive-sm">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Product</th>
									<th class="center">Quantity</th>
									<th class="right">Price</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sessionScope.cart }" var="itemMap">
									<tr>
										<td class="left strong">${itemMap.value.product.productName }</td>
										<td class="center">${itemMap.value.quantity }</td>
										<td class="right">${itemMap.value.product.price * itemMap.value.quantity }
											$</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<form action="${pageContext.request.contextPath }/done" class="billing-form">
						<div class="row">
							<div class="col-lg-4 col-sm-5 ml-auto">
								<table class="table table-clear">
									<tbody>
										<tr>
											<td class="left"><strong>Total</strong></td>
											<td class="right"><strong>${sessionScope.sum }$</strong></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<button class="view-btn color-2 w-100 mt-20" type="submit">
							<span>DONE</span>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<hr>

	</div>

</body>
</html>