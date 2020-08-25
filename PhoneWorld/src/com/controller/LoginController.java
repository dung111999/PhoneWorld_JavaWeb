package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

@WebServlet("/admin-tp/user/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.login(username, password);
		
		if(admin != null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("admin", admin);
			resp.sendRedirect(req.getContextPath() + "/admin/user/dashboard");
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin-tp/user/login");
			System.out.println("Failed");
		}
	}
	
	
}
