package com.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.model.CartItem;

public interface CartItemService {
	void insert(HttpServletRequest req);

	void editWaitToOrdered(CartItem cartItem);

	void editOrderedToWait(CartItem cartItem);

	void delete(int id);

	CartItem get(int id);

	List<CartItem> getId(int id);

	List<CartItem> search(String buyerName);
}
