package com.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.TableOrderDao;
import com.dao.impl.TableOrderDaoImpl;
import com.jdbc.JDBCConnection;
import com.model.CartItem;
import com.model.TableOrders;
import com.service.TableOrderService;

public class TableOrderServiceImpl extends JDBCConnection implements TableOrderService {
	TableOrderDao tableOrderDao = new TableOrderDaoImpl();
	
	@Override
	public void insert(CartItem cartItem, HttpServletRequest req) {
		tableOrderDao.insert(cartItem, req);
	}

	@Override
	public List<TableOrders> search(String buyerName) {
		return tableOrderDao.search(buyerName);
	}

	@Override
	public void delete(int id) {
		tableOrderDao.delete(id);
	}

}
