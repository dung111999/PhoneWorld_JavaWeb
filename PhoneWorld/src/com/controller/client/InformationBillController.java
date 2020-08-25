package com.controller.client;

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

import com.model.Brand;
import com.service.BrandService;
import com.service.CartItemService;
import com.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = "/client/informationBill")
public class InformationBillController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);

		long millis = System.currentTimeMillis();
		Date date = new java.sql.Date(millis);
		System.out.println(date);
		session.setAttribute("date", date);

		String fullName = req.getParameter("fullName");
		session.setAttribute("fullName", fullName);

		String phone = req.getParameter("phoneOrder");
		session.setAttribute("phoneOrder", phone);

		String address = req.getParameter("deliveryAddress");
		session.setAttribute("deliveryAddress", address);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/bill-information.jsp");
		dispatcher.forward(req, resp);

	}
}
