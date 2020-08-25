package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CartItem;
import com.service.CartItemService;
import com.service.TableOrderService;
import com.service.impl.CartItemServiceImpl;
import com.service.impl.TableOrderServiceImpl;


@WebServlet(urlPatterns = "/admin/cart-item/order")
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartItemId = req.getParameter("cartItemId");
		CartItemService cartItemService = new CartItemServiceImpl();
		CartItem cartItem = cartItemService.get(Integer.parseInt(cartItemId));
		
		long millis = System.currentTimeMillis();
		Date date = new java.sql.Date(millis);
		
		HttpSession session = req.getSession();
		session.setAttribute("dateOrder", date);
		
		TableOrderService tableOrderService = new TableOrderServiceImpl();
		tableOrderService.insert(cartItem, req);
		
		cartItemService.editWaitToOrdered(cartItem);
		
		resp.sendRedirect(req.getContextPath() + "/admin/cart-item/list");
	}
}
