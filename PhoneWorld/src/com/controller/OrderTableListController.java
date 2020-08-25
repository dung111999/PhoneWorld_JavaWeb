package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.TableOrders;
import com.service.TableOrderService;
import com.service.impl.TableOrderServiceImpl;

@WebServlet(urlPatterns = "/admin/order-table")
public class OrderTableListController extends HttpServlet {
	TableOrderService tableOrderService = new TableOrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TableOrders> tableOrdersList = tableOrderService.search("");
		req.setAttribute("tableOrdersList", tableOrdersList);
		
		long sum = 0;
		for(int i = 0; i < tableOrdersList.size(); i++) {
			sum += tableOrdersList.get(i).getCartItem().getQuantity() * tableOrdersList.get(i).getCartItem().getProduct().getPrice();
		}
		
		req.setAttribute("sum", sum);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/table-order.jsp");
		dispatcher.forward(req, resp);
	}
	
}
