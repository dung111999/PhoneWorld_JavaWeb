package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.jdbc.JDBCConnection;
import com.model.Brand;
import com.model.Product;
import com.service.BrandService;
import com.service.impl.BrandServiceImpl;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {
	BrandService brandService = new BrandServiceImpl();

	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product(brand_id,name,price,ram,rom,cpu,pin,image) VALUES(?,?,?,?,?,?,?,?)";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getBrand().getId());
			ps.setString(2, product.getProductName());
			ps.setLong(3, product.getPrice());
			ps.setInt(4, product.getRam());
			ps.setInt(5, product.getRom());
			ps.setString(6, product.getCPU());
			ps.setInt(7, product.getPin());
			ps.setString(8, product.getImage());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Product product) {
		String sql = "UPDATE product SET brand_id = ?, name = ?, price = ?, ram = ?, rom = ?,cpu = ?, pin = ?, image = ? WHERE id = ?";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getBrand().getId());
			ps.setString(2, product.getProductName());
			ps.setLong(3, product.getPrice());
			ps.setInt(4, product.getRam());
			ps.setInt(5, product.getRom());
			ps.setString(6, product.getCPU());
			ps.setInt(7, product.getPin());
			ps.setString(8, product.getImage());
			ps.setInt(9, product.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";
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
	public Product get(int id) {
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.ram, product.rom,product.cpu, product.pin, product.image, brand.brand AS b_brand, brand.id AS b_id FROM product INNER JOIN brand ON product.brand_id = brand.id WHERE product.id = ?";
		Connection conn = super.getJDBCConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = brandService.get(rs.getInt("b_id"));

				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setRam(rs.getInt("ram"));
				product.setRom(rs.getInt("rom"));
				product.setCPU(rs.getString("CPU"));
				product.setPin(rs.getInt("pin"));
				product.setImage(rs.getString("image"));
				product.setBrand(brand);

				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> pList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.ram, product.rom, product.cpu, product.pin, product.image, brand.brand AS b_name,brand.id AS b_id FROM product INNER JOIN brand ON product.brand_id = brand.id";
		Connection conn = super.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = brandService.get(rs.getInt("b_id"));

				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setRam(rs.getInt("ram"));
				product.setRom(rs.getInt("rom"));
				product.setCPU(rs.getString("CPU"));
				product.setPin(rs.getInt("pin"));
				product.setImage(rs.getString("image"));
				product.setBrand(brand);

				pList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public List<Product> search(String name) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id AS product_id, product.name, product.price, product.ram, product.rom,product.cpu, product.pin, product.image, brand.id AS brand_id, brand.brand FROM product INNER JOIN brand ON brand.id = product.brand_id WHERE product.name LIKE ?";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				product.setRam(rs.getInt("ram"));
				product.setRom(rs.getInt("rom"));
				product.setCPU(rs.getString("CPU"));
				product.setPin(rs.getInt("pin"));
				product.setImage(rs.getString("image"));

				Brand brand = new Brand();
				brand.setId(rs.getInt("brand_id"));
				brand.setBrand(rs.getString("brand"));
				product.setBrand(brand);

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> searchBrand(String brandName) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id AS product_id, product.name, product.price, product.ram, product.rom,product.cpu, product.pin, product.image, brand.id AS brand_id, brand.brand FROM product INNER JOIN brand ON brand.id = product.brand_id WHERE brand.brand LIKE ?";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + brandName + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProductName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				product.setRam(rs.getInt("ram"));
				product.setRom(rs.getInt("rom"));
				product.setCPU(rs.getString("CPU"));
				product.setPin(rs.getInt("pin"));
				product.setImage(rs.getString("image"));

				Brand brand = new Brand();
				brand.setId(rs.getInt("brand_id"));
				brand.setBrand(rs.getString("brand"));
				product.setBrand(brand);

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> getId(int id) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.ram, product.rom,product.cpu, product.pin, product.image, brand.brand AS b_brand, brand.id AS b_id FROM product INNER JOIN brand ON product.brand_id = brand.id WHERE product.id = ?";
		Connection conn = super.getJDBCConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = brandService.get(rs.getInt("b_id"));

				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setRam(rs.getInt("ram"));
				product.setRom(rs.getInt("rom"));
				product.setCPU(rs.getString("CPU"));
				product.setPin(rs.getInt("pin"));
				product.setImage(rs.getString("image"));
				product.setBrand(brand);

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

}
