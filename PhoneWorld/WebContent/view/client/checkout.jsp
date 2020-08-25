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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/client/css/main.css">
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
		<div class="container">
			<form
				action="${pageContext.request.contextPath }/client/informationBill"
				class="billing-form" method="post">
				<div class="row">
					<div class="col-lg-8 col-md-6">
						<h3 class="billing-title mt-20 mb-10">Billing Details</h3>
						<div class="row">
							<div class="col-lg-12">
								<input type="text" name="fullName" placeholder="Full name*"
									onfocus="this.placeholder=''"
									onblur="this.placeholder = 'Full name*'" required
									class="common-input">
							</div>
							<div class="col-lg-12">
								<input type="text" name="phoneOrder" placeholder="Phone number*"
									onfocus="this.placeholder=''"
									onblur="this.placeholder = 'Phone number*'" required
									class="common-input">
							</div>
							<div class="col-lg-12">
								<input type="text" name="deliveryAddress"
									placeholder="Delivery Address" onfocus="this.placeholder=''"
									onblur="this.placeholder = 'Delivery Address'" required
									class="common-input">
							</div>
							<button class="view-btn color-2 w-100 mt-20" type="submit">
								<span>Proceed to Checkout</span>
							</button>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="order-wrapper mt-50">
							<h3 class="billing-title mb-10">Your Order</h3>
							<div class="order-list">
								<div class="list-row d-flex justify-content-between">
									<div>Product</div>
									<div>Quantity</div>
									<div>Total</div>
								</div>
								<c:forEach items="${sessionScope.cart }" var="itemMap">
									<div class="row">

										<div class="col-sm-7">${itemMap.value.product.productName }</div>
										<div class="col-sm-2">${itemMap.value.quantity }</div>
										<div class="col-sm-3">${itemMap.value.product.price * itemMap.value.quantity }
											$</div>

									</div>
								</c:forEach>
								<div class="list-row d-flex justify-content-between">
									<h6>Total</h6>
									<div class="total">${sessionScope.sum }$</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<hr>
		<hr>

	</div>

</body>
</html>