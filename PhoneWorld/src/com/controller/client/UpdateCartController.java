package com.controller.client;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CartItem;
import com.model.Product;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/update-cart-item")
public class UpdateCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String quantity = req.getParameter("quantity");

		long sum = 0;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("cart");

		String productId = req.getParameter("key");
		ProductService productService = new ProductServiceImpl();
		Product product = productService.get(Integer.parseInt(productId));

		if (object != null) {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) session.getAttribute("cart");
			Set<Integer> set = map.keySet();
			CartItem cartItem = map.get(Integer.parseInt(key));
			cartItem.setQuantity(Integer.parseInt(quantity));

			for (Integer key1 : set) {
				sum += map.get(key1).getQuantity() * product.getPrice();
			}
			session.setAttribute("sum", sum);
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/cart/list");
	}
}
