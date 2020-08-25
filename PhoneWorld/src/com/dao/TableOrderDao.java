package com.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.model.CartItem;
import com.model.TableOrders;

public interface TableOrderDao {
	void insert(CartItem cartItem, HttpServletRequest req);
	
	void delete(int id);
	
	List<TableOrders> search(String buyerName);
}
