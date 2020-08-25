package com.service;

import java.util.List;

import com.model.Admin;

public interface AdminService {
	void insert(Admin admin);
	
	void edit(Admin admin);
	
	void delete(int id);
	
	Admin get(String adminName);
	
	Admin get(int id);
	
	Admin login(String username, String password);
	
	List<Admin> getAll();
	
	List<Admin> search(String keyword);
}
