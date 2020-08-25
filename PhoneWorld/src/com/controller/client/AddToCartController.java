package com.controller.client;

import java.io.IOException;
import java.util.HashMap;
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
import com.service.BrandService;
import com.service.ProductService;
import com.service.impl.BrandServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/add-to-cart")
public class AddToCartController extends HttpServlet {
	BrandService brandService = new BrandServiceImpl();
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long sum = 0;
		String productId = req.getParameter("productId");
		Product product = productService.get(Integer.parseInt(productId));
//		System.out.println(productId);

		HttpSession session = req.getSession();

		Object object = session.getAttribute("cart");

		if (object == null) {
			CartItem cartItem = new CartItem();
			cartItem.setQuantity(1);
//			cartItem.setPrice(product.getPrice());
			cartItem.setProduct(product);

			Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
			map.put(product.getId(), cartItem);

			sum = product.getPrice();

			session.setAttribute("sum", sum);
			session.setAttribute("cart", map);
		} else {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) session.getAttribute("cart");
			CartItem cartItem = map.get(product.getId());

			Set<Integer> set = map.keySet();

			if (cartItem == null) {
				CartItem item = new CartItem();
				item.setQuantity(1);
				item.setProduct(product);
				map.put(product.getId(), item);
			} else {
				cartItem.setQuantity(cartItem.getQuantity());
			}

			for (Integer key : set) {
				sum += map.get(key).getQuantity() * map.get(key).getProduct().getPrice();
			}

			session.setAttribute("sum", sum);
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/cart/list");
	}
}
