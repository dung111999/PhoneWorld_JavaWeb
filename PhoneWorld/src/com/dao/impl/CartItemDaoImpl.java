package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.CartItemDao;
import com.jdbc.JDBCConnection;
import com.model.CartItem;
import com.model.Product;
import com.model.Status;

public class CartItemDaoImpl extends JDBCConnection implements CartItemDao {

	@Override
	public List<CartItem> search(String buyerName) {
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		String sql = "SELECT cartitem.id AS cartitem_id, cartitem.buyer_name, cartitem.buyer_address, cartitem.buyer_phone, product.id AS product_id, product.name,product.image, product.price, cartitem.quantity, cartitem.buy_date, status.status FROM cartitem INNER JOIN product ON cartitem.product_id = product.id INNER JOIN status ON cartitem.status = status.id WHERE cartitem.buyer_name LIKE ? OR cartitem.buyer_address LIKE ? OR cartitem.buyer_phone LIKE ? OR product.name LIKE ?";

		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + buyerName + "%");
			ps.setString(2, "%" + buyerName + "%");
			ps.setString(3, "%" + buyerName + "%");
			ps.setString(4, "%" + buyerName + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));

				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("cartitem_id"));
				cartItem.setBuyerName(rs.getString("buyer_name"));
				cartItem.setBuyerAddress(rs.getString("buyer_address"));
				cartItem.setBuyerPhone(rs.getString("buyer_phone"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setBuyDate(rs.getDate("buy_date"));

				Status status = new Status();
				status.setStatus(rs.getString("status"));

				cartItem.setStatus(status);
				cartItem.setProduct(product);

				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemList;
	}

	@Override
	public void insert(HttpServletRequest req) {
		HttpSession session = req.getSession();

		Map<Integer, CartItem> map = (Map<Integer, CartItem>) session.getAttribute("cart");
		Set<Integer> set = map.keySet();

		Connection conn = super.getJDBCConnection();

		String sql = "INSERT INTO cartitem(buyer_name, buyer_address, buyer_phone, product_id, quantity, buy_date) VALUES (?,?,?,?,?,?)";

		Date date = (Date) session.getAttribute("date");

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			for (Integer key : set) {
				ps.setString(1, (String) session.getAttribute("fullName"));
				ps.setString(2, (String) session.getAttribute("deliveryAddress"));
				ps.setString(3, (String) session.getAttribute("phoneOrder"));
				ps.setInt(4, map.get(key).getProduct().getId());
				ps.setInt(5, map.get(key).getQuantity());
				ps.setDate(6, date);

				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM cartitem WHERE cartitem.id = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CartItem get(int id) {
		String sql = "SELECT cartitem.id AS cartitem_id, cartitem.buyer_name, cartitem.buyer_address, cartitem.buyer_phone, product.id AS product_id, product.name, product.price, cartitem.quantity FROM product INNER JOIN cartitem ON product.id = cartitem.product_id WHERE cartitem.id = ? ";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CartItem cartItem = new CartItem();

				cartItem.setId(rs.getInt("cartitem_id"));
				cartItem.setBuyerName(rs.getString("buyer_name"));
				cartItem.setBuyerAddress(rs.getString("buyer_address"));
				cartItem.setBuyerPhone(rs.getString("buyer_phone"));
				cartItem.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));

				cartItem.setProduct(product);

				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void editWaitToOrdered(CartItem cartItem) {
		String sql = "UPDATE cartitem SET cartitem.status = 2 WHERE cartitem.id = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editOrderedToWait(CartItem cartItem) {
		String sql = "UPDATE cartitem SET cartitem.status = 1 WHERE cartitem.id = ?";
		Connection conn = super.getJDBCConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartItem.getId());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CartItem> getId(int id) {
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		String sql = "SELECT cartitem.id AS cartitem_id, cartitem.buyer_name, cartitem.buyer_address, cartitem.buyer_phone, product.id AS product_id, product.name,product.image, product.price, cartitem.quantity, cartitem.buy_date, status.status FROM cartitem INNER JOIN product ON cartitem.product_id = product.id INNER JOIN status ON cartitem.status = status.id WHERE cartitem.id = ?";

		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));

				CartItem cartItem = new CartItem();
				cartItem.setId(rs.getInt("cartitem_id"));
				cartItem.setBuyerName(rs.getString("buyer_name"));
				cartItem.setBuyerAddress(rs.getString("buyer_address"));
				cartItem.setBuyerPhone(rs.getString("buyer_phone"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setBuyDate(rs.getDate("buy_date"));

				Status status = new Status();
				status.setStatus(rs.getString("status"));

				cartItem.setStatus(status);
				cartItem.setProduct(product);

				cartItemList.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemList;
	}

}
