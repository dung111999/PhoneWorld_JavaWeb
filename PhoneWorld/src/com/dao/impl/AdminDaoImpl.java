package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dao.AdminDao;
import com.jdbc.JDBCConnection;
import com.model.Admin;

public class AdminDaoImpl extends JDBCConnection implements AdminDao {

	@Override
	public void insert(Admin admin) {
		
	}

	@Override
	public void edit(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin get(String username) {
		String sql = "SELECT * FROM admin WHERE username = ?";
		Connection con = super.getJDBCConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Admin admin = new Admin();
				
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				
				return admin;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> search(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
