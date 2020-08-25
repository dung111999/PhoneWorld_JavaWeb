package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;
import com.service.BrandService;
import com.service.ProductService;
import com.service.impl.BrandServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> proList = productService.getAll();
		req.setAttribute("proList", proList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/list-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String nameId = req.getParameter("nameId");

		if (name != null) {
			List<Product> productList = productService.search(name);
			req.setAttribute("proList", productList);
		} else if (nameId != null) {
			List<Product> productList = productService.getId(Integer.parseInt(nameId));
			req.setAttribute("proList", productList);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/list-product.jsp");
		dispatcher.forward(req, resp);
	}
}
