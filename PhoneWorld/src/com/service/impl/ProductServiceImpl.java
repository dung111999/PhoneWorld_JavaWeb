package com.service.impl;

import java.io.File;
import java.util.List;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.jdbc.JDBCConnection;
import com.model.Product;
import com.service.ProductService;

public class ProductServiceImpl extends JDBCConnection implements ProductService {
	ProductDao productDao = new ProductDaoImpl(); 

	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}

	@Override
	public void edit(Product newProduct) {
		Product oldProduct = productDao.get(newProduct.getId());
		
		oldProduct.setProductName(newProduct.getProductName());;
		oldProduct.setBrand(newProduct.getBrand());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setRam(newProduct.getRam());
		oldProduct.setRom(newProduct.getRom());
		oldProduct.setBrand(newProduct.getBrand());
		
		if(newProduct.getImage() != null) {
			String fileName = oldProduct.getImage();
			final String dir = "C:\\Users\\84168\\Desktop\\JAVA_WEB\\PhoneWorld\\WebContent\\static\\admin\\image";
			File file = new File(dir + "/" + fileName);
			if(file.exists()) {
				file.delete();
			}
			
			oldProduct.setImage(newProduct.getImage());
		}
		
		productDao.edit(oldProduct);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public Product get(int id) {
		return productDao.get(id);
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public List<Product> search(String name) {
		return productDao.search(name);
	}

	@Override
	public List<Product> searchBrand(String brandName) {
		return productDao.searchBrand(brandName);
	}

	@Override
	public List<Product> getId(int id) {
		return productDao.getId(id);
	}

}
