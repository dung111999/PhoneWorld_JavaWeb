<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Edit Product</title>

<!-- Custom fonts for this template -->
<c:url value="/static/admin/css/style.css" var="style"></c:url>
<link href="${style}" rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath }/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/sb-admin-2.min.css"
	rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="${pageContext.request.contextPath }/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="${pageContext.request.contextPath }/admin/user/dashboard">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Dashboard</div>
			</a>



			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Brands</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item"
							href="${pageContext.request.contextPath}/admin/brand/list">List
							Brands</a> <a class="collapse-item"
							href="${pageContext.request.contextPath}/admin/brand/add">Add
							Brands</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <span>Products</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item"
							href="${pageContext.request.contextPath }/admin/product/list">List
							Products</a> <a class="collapse-item"
							href="${pageContext.request.contextPath }/admin/product/add">Add
							Products</a>
					</div>
				</div></li>

			<li class="nav-item"><a class="nav-link collapsed"
				href="${pageContext.request.contextPath }/admin/cart-item/list"
				data-target="#collapseUtilities" aria-expanded="true"
				aria-controls="collapseUtilities"> <span>Cart Items</span>
			</a></li>

			<li class="nav-item"><a class="nav-link collapsed"
				href="${pageContext.request.contextPath }/admin/order-table"
				data-target="#collapseUtilities" aria-expanded="true"
				aria-controls="collapseUtilities"> <span>Table Orders</span>
			</a></li>


		</ul>


		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">


					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>


						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${admin.username }</span>
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item"
									href="${pageContext.request.contextPath }/admin/user/logout">
									<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- DataTales Example -->
					<div class="signup-block bg">
						<h2 id="ha">Edit Product</h2>
						<c:url value="/admin/product/edit" var="editProduct"></c:url>
						<form action="${editProduct}" method="post" id="ha"
							enctype="multipart/form-data">
							Id <input type="text" readonly="readonly" name="id"
								value="${product.id }"> <label for="exampleInputName">Name</label>
							<input type="text" name="productname"
								value="${product.productName }"> <label
								for="exampleInputName">Price</label> <input type="text"
								name="price" value="${product.price }"> <label
								for="exampleInputName">Ram</label> <input type="text" name="ram"
								value="${product.ram }"> <label for="exampleInputName">Rom</label>
							<input type="text" name="rom" value="${product.rom }"><label
								for="exampleInputName">CPU</label> <input type="text" name="CPU"
								value="${product.CPU }"><label for="exampleInputName">Pin</label>
							<input type="text" name="pin" value="${product.pin }"> <label
								for="exampleInputImage">Image</label> <input type="file"
								name="image"> <img height="150"
								src='<c:url value="/image?fname=${product.image }"/>' />
							<p>
								<br>
							</p>
							<p>
								<br>
							</p>
							<label for="exampleInputUsername">Brand</label> <select
								name="brands" value="">
								<c:forEach items="${brands}" var="brands">
									<option value="${brands.brand}">${brands.brand}</option>
								</c:forEach>
							</select> <br> <input type="submit" name="editProduct" value="Submit">
							</br>
						</form>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->


	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script
		src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script
		src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>

</body>

</html>
