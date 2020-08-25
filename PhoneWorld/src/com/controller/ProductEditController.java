package com.controller;

import java.io.File;
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

@WebServlet(urlPatterns = { "/admin/product/edit" })
public class ProductEditController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	BrandService brandService = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		List<Brand> brands = brandService.getAll();

		req.setAttribute("brands", brands);

		req.setAttribute("product", product);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/edit-product.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			System.out.println(items);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					product.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("productname")) {
					product.setProductName(item.getString());
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
				} else if (item.getFieldName().equals("brands")) {
					product.setBrand(brandService.get(item.getString()));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						final String dir = "C:\\Users\\84168\\Desktop\\JAVA_WEB\\PhoneWorld\\WebContent\\static\\admin\\image";
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(dir + "/" + fileName);
						item.write(file);
						product.setImage(fileName);
					}
				}
			}
			productService.edit(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
