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

@WebServlet(urlPatterns = "/remove-cart-item")
public class RemoveCartItemController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		HttpSession session = req.getSession();

		Object object = session.getAttribute("cart");

		long sum = (long) session.getAttribute("sum");
//		System.out.println(sum);

		String productId = req.getParameter("key");
		session.setAttribute("productId", productId);
		ProductService productService = new ProductServiceImpl();
		Product product = productService.get(Integer.parseInt(productId));

		if (object != null) {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) session.getAttribute("cart");

			long sum1 = map.get(Integer.parseInt(key)).getQuantity() * product.getPrice();

			sum = sum - sum1;

			map.remove(Integer.parseInt(key));

			session.setAttribute("sum", sum);
			session.setAttribute("cart", map);
		}

		resp.sendRedirect(req.getContextPath() + "/cart/list");
	}

}
