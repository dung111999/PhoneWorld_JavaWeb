package com.service.impl;

import java.util.List;

import com.dao.BrandDao;
import com.dao.impl.BrandDaoImpl;
import com.jdbc.JDBCConnection;
import com.model.Brand;
import com.service.BrandService;

public class BrandServiceImpl extends JDBCConnection implements BrandService {
	BrandDao branDao = new BrandDaoImpl();

	@Override
	public void insert(Brand brand) {
		branDao.insert(brand);
	}

	@Override
	public void edit(Brand newBrand) {
		Brand oldBrand = branDao.get(newBrand.getId());
		
		oldBrand.setBrand(newBrand.getBrand());
		
		branDao.edit(oldBrand);
	}

	@Override
	public void delete(int id) {
		branDao.delete(id);
	}

	@Override
	public Brand get(String name) {
		return branDao.get(name);
	}

	@Override
	public Brand get(int id) {
		return branDao.get(id);
	}

	@Override
	public List<Brand> getAll() {
		return branDao.getAll();
	}

	@Override
	public List<Brand> search(String name) {
		return branDao.search(name);
	}

	@Override
	public List<Brand> getId(int id) {
		return branDao.getId(id);
	}


}
