package com.service.impl;

import java.util.List;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.model.Admin;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public void insert(Admin admin) {
		// TODO Auto-generated method stub
		
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
	public Admin get(String adminName) {
		return adminDao.get(adminName);
	}

	@Override
	public Admin get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin login(String username, String password) {
		Admin admin = this.get(username);
		
		if(admin != null && password.equals(admin.getPassword())) {
			return admin;
		}
		return null;
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
