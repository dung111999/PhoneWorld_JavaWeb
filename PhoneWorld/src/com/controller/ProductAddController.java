package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.Brand;
import com.model.Product;
import com.service.BrandService;
import com.service.ProductService;
import com.service.impl.BrandServiceImpl;
import com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/add" })
public class ProductAddController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brands = brandService.getAll();
		req.setAttribute("brands", brands);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/add-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setProductName(item.getString());
				} else if (item.getFieldName().equals("brandid")) {
					product.setBrand(brandService.get(item.getString()));
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("ram")) {
					product.setRam(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("rom")) {
					product.setRom(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("CPU")) {
					product.setCPU(item.getString());
				} else if (item.getFieldName().equals("pin")) {
					product.setPin(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String location = "C:\\Users\\84168\\Desktop\\JAVA_WEB\\PhoneWorld\\WebContent\\static\\admin\\image";
						String fileName = item.getName();
						int index = fileName.lastIndexOf(".");
						String ext = fileName.substring(index);
						String saveFileName = System.currentTimeMillis() + ext;

						FileOutputStream fileOutputStream = new FileOutputStream(
								location + File.separator + saveFileName);
						fileOutputStream.write(item.get());

						fileOutputStream.flush();
						fileOutputStream.close();

						product.setImage(saveFileName);
						;
					}
				}
			}
			productService.insert(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
