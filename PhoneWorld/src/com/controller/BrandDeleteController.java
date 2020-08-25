package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = {"/admin/brand/delete"})
public class BrandDeleteController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		brandService.delete(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath() +"/admin/brand/list");
	}
}
