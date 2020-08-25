package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Brand;
import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = {"/admin/brand/add"})
public class BrandAddController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/brand/add-brand.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("brandname");
		
		Brand brand = new Brand();
		brand.setBrand(name);
		
		brandService.insert(brand);
		resp.sendRedirect(req.getContextPath() + "/admin/brand/list");
	}
}
