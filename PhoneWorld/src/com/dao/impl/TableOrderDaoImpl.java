package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.TableOrderDao;
import com.jdbc.JDBCConnection;
import com.model.CartItem;
import com.model.Product;
import com.model.TableOrders;

import sun.print.resources.serviceui;

public class TableOrderDaoImpl extends JDBCConnection implements TableOrderDao {

	@Override
	public void insert(CartItem cartItem, HttpServletRequest req) {
		String sql = "INSERT INTO tableorders(cartitem_id, order_date) VALUES (?, ?)";
		Connection conn = super.getJDBCConnection();
		HttpSession session = req.getSession();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getId());
			ps.setDate(2, (Date) session.getAttribute("dateOrder"));

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			if(e != null) {
				System.out.println("Co loi ");
			}
		}
	}

	@Override
	public List<TableOrders> search(String buyerName) {
		List<TableOrders> tableOrderList = new ArrayList<TableOrders>();
		String sql = "SELECT tableorders.id AS tableorders_id, cartitem.id AS cartitem_id, cartitem.buyer_name, cartitem.buyer_address, cartitem.buyer_phone, cartitem.buy_date, product.id AS product_id, product.name, product.price, cartitem.quantity, product.image, tableorders.order_date FROM cartitem, product, tableorders WHERE cartitem.id = tableorders.cartitem_id and product.id = cartitem.product_id and cartitem.buyer_name LIKE ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + buyerName + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TableOrders tableOrders = new TableOrders();
				tableOrders.setId(rs.getInt("tableorders_id"));
				tableOrders.setDate(rs.getDate("order_date"));

				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("cartitem_id"));
				cartItem.setBuyerName(rs.getString("buyer_name"));
				cartItem.setBuyerAddress(rs.getString("buyer_address"));
				cartItem.setBuyerPhone(rs.getString("buyer_phone"));
				cartItem.setBuyDate(rs.getDate("buy_date"));
				cartItem.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));

				cartItem.setProduct(product);

				tableOrders.setCartItem(cartItem);

				tableOrderList.add(tableOrders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tableOrderList;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM tableorders WHERE tableorders.cartitem_id = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
