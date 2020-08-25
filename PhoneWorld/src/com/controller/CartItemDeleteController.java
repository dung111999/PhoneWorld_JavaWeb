package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CartItemService;
import com.service.impl.CartItemServiceImpl;

@WebServlet(urlPatterns = "/admin/cart-item/delete")
public class CartItemDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartItemListId = req.getParameter("cartItemId");
		CartItemService cartItemService = new CartItemServiceImpl();
		cartItemService.delete(Integer.parseInt(cartItemListId));
		
		resp.sendRedirect(req.getContextPath() + "/admin/cart-item/list");
	}
}
