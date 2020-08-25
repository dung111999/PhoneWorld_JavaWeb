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
import javax.servlet.http.HttpSession;

import com.model.CartItem;
import com.model.Product;
import com.service.CartItemService;
import com.service.ProductService;
import com.service.impl.CartItemServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/cart-item/list")
public class CartItemListController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CartItem> cartItemList = cartItemService.search("");

		HttpSession session = req.getSession();
		session.setAttribute("cartItemList", cartItemList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/cart-admin.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String nameId = req.getParameter("nameId");

		if (name != null) {
			List<CartItem> cartItemList = cartItemService.search(name);

			req.setAttribute("cartItemList", cartItemList);
		} else if(nameId != null) {
			List<CartItem> cartItemList = cartItemService.getId(Integer.parseInt(nameId));
			
			req.setAttribute("cartItemList", cartItemList);
		}
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/cart-admin.jsp");
		dispatcher.forward(req, resp);
	}
}