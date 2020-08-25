package com.service.impl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.CartItemDao;
import com.dao.impl.CartItemDaoImpl;
import com.jdbc.JDBCConnection;
import com.model.CartItem;
import com.service.CartItemService;

public class CartItemServiceImpl extends JDBCConnection implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();
	
	@Override
	public void insert(HttpServletRequest req) {
		cartItemDao.insert(req);
	}

	@Override
	public List<CartItem> search(String buyerName) {
		return cartItemDao.search(buyerName);
	}

	@Override
	public void delete(int id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public void editWaitToOrdered(CartItem newCartItem) {
		CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
		
		cartItemDao.editWaitToOrdered(oldCartItem);
	}

	@Override
	public void editOrderedToWait(CartItem newCartItem) {
		CartItem olCartItem = cartItemDao.get(newCartItem.getId());
		
		cartItemDao.editOrderedToWait(olCartItem);
	}

	@Override
	public List<CartItem> getId(int id) {
		return cartItemDao.getId(id);
	}


}
