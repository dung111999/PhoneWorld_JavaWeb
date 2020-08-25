package com.dao;

import java.util.List;

import com.model.Brand;

public interface BrandDao {
	void insert(Brand brand);
	
	void edit(Brand brand);
	
	void delete(int id);
	
	Brand get(String name);
	
	Brand get(int id);
	
	List<Brand> getId(int id);
	
	List<Brand> getAll();
	
	List<Brand> search(String name);
}
