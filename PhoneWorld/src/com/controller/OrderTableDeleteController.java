package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CartItemService;
import com.service.TableOrderService;
import com.service.impl.CartItemServiceImpl;
import com.service.impl.TableOrderServiceImpl;

@WebServlet(urlPatterns = "/admin/order-table/delete")
public class OrderTableDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TableOrderService tableOrderService = new TableOrderServiceImpl();
		CartItemService cartItemService = new CartItemServiceImpl();
		String id = req.getParameter("tableOrderId");
		
		tableOrderService.delete(Integer.parseInt(id));
		cartItemService.editOrderedToWait(cartItemService.get(Integer.parseInt(id)));
		resp.sendRedirect(req.getContextPath() + "/admin/order-table");
	}
}
