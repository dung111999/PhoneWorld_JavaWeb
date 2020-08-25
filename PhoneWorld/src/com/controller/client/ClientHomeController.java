package com.controller.client;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = "/home")
public class ClientHomeController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);
		List<Product> products = productService.getAll();
		req.setAttribute("products", products);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/home.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		List<Product> productList = productService.search(name);
		
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);

		req.setAttribute("products", productList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/home.jsp");
		dispatcher.forward(req, resp);

	}
}
