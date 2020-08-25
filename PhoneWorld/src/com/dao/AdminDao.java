package com.dao;

import java.util.List;

import com.model.Admin;

public interface AdminDao {
	void insert(Admin admin);
	
	void edit(Admin admin);
	
	void delete(int id);
	
	Admin get(String username);
	
	Admin get(int id);
	
	List<Admin> getAll();
	
	List<Admin> search(String username);
}
