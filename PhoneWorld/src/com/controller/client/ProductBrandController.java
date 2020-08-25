package com.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Brand;
import com.model.Product;
import com.service.BrandService;
import com.service.ProductService;
import com.service.impl.BrandServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/home/brand")
public class ProductBrandController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brandName = req.getParameter("brandname");
		List<Product> productSearchByBrand = productService.searchBrand(brandName);

		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);

		req.setAttribute("productSearchByBrand", productSearchByBrand);
		req.getRequestDispatcher("/view/client/home-brand.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/home-brand.jsp");
		dispatcher.forward(req, resp);
	}

}
