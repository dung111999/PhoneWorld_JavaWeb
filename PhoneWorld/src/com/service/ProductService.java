package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	void insert(Product product);
	
	void edit(Product product);
	
	void delete(int id);
	
	Product get(int id);
	
	List<Product> getId(int id);
	
	List<Product> getAll();
	
	List<Product> search(String name);
	
	List<Product> searchBrand(String brandName);
}
