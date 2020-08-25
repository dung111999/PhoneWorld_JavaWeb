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
import com.service.BrandService;
import com.service.ProductService;
import com.service.impl.BrandServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/cart/list")
public class CartListController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();
	ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/cart.jsp");
		dispatcher.forward(req, resp);
	}
}
