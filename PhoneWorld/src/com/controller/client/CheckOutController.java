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
import com.service.impl.BrandServiceImpl;


@WebServlet(urlPatterns = "/client/checkout")
public class CheckOutController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/client/checkout.jsp");
		rd.forward(req, resp);
	}
}
