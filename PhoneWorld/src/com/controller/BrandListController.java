package com.controller;

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
import com.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = "/admin/brand/list")
public class BrandListController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brandList = brandService.getAll();
		req.setAttribute("brandList", brandList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/brand/list-brand.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String nameId = req.getParameter("nameId");

		if (name != null) {
			List<Brand> brandList = brandService.search(name);
			req.setAttribute("brandList", brandList);
		} else if (nameId != null) {
			List<Brand> brandList = brandService.getId(Integer.parseInt(nameId));
			req.setAttribute("brandList", brandList);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/brand/list-brand.jsp");
		dispatcher.forward(req, resp);
	}
}
