package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BrandDao;
import com.jdbc.JDBCConnection;
import com.model.Brand;

public class BrandDaoImpl extends JDBCConnection implements BrandDao {

	@Override
	public void insert(Brand brand) {
		String sql = "INSERT INTO brand(brand) VALUES (?)";
		Connection con = super.getJDBCConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, brand.getBrand());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(Brand brand) {
		String sql = "UPDATE brand SET brand = ? WHERE id = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, brand.getBrand());
			ps.setInt(2, brand.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM brand WHERE id = ?";
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
	public Brand get(String name) {
		String sql = "SELECT * FROM brand WHERE brand = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();

				brand.setId(rs.getInt("id"));
				brand.setBrand(rs.getString("brand"));
				return brand;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Brand get(int id) {
		String sql = "SELECT * FROM brand WHERE id = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();

				brand.setId(rs.getInt("id"));
				brand.setBrand(rs.getString("brand"));
				return brand;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Brand> getAll() {
		List<Brand> brandList = new ArrayList<Brand>();
		String sql = "SELECT * FROM brand";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();

				brand.setId(rs.getInt("id"));
				brand.setBrand(rs.getString("brand"));

				brandList.add(brand);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brandList;
	}

	@Override
	public List<Brand> search(String name) {
		List<Brand> brands = new ArrayList<Brand>();
		String sql = "SELECT * FROM brand WHERE brand LIKE ?";

		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setBrand(rs.getString("brand"));

				brands.add(brand);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brands;
	}

	@Override
	public List<Brand> getId(int id) {
		List<Brand> brandList = new ArrayList<Brand>();
		String sql = "SELECT * FROM brand WHERE brand.id = ?";

		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt("id"));
				brand.setBrand(rs.getString("brand"));

				brandList.add(brand);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return brandList;
	}

}
