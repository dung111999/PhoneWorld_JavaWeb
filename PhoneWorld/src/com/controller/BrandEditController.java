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

@WebServlet(urlPatterns = { "/admin/brand/edit" })
public class BrandEditController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Brand brand = brandService.get(Integer.parseInt(id));
		
		req.setAttribute("brand", brand);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/brand/edit-brand.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Brand brand = new Brand();
		brand.setId(Integer.parseInt(req.getParameter("id")));
		brand.setBrand(req.getParameter("brandname"));
		brandService.edit(brand);
		
		resp.sendRedirect(req.getContextPath() + "/admin/brand/list");
	}
}
