package com.controller.client;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Brand;
import com.model.CartItem;
import com.service.BrandService;
import com.service.CartItemService;
import com.service.impl.BrandServiceImpl;
import com.service.impl.CartItemServiceImpl;

@WebServlet(urlPatterns = "/done")
public class DoneController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BrandService brandService = new BrandServiceImpl();
		
		CartItemService cartItemService = new CartItemServiceImpl();
		
		cartItemService.insert(req);
		
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);
		
		HttpSession session = req.getSession();
		session.removeAttribute("sum");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/done.jsp");
		dispatcher.forward(req, resp);
	}
}
