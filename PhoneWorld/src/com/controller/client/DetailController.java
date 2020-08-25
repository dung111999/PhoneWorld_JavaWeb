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

@WebServlet(urlPatterns = "/detail")
public class DetailController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	BrandService brandService = new BrandServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		req.setAttribute("product", product);
		
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/detail.jsp");
		dispatcher.forward(req, resp);
	}
}
