package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

@WebServlet(urlPatterns = "/product/download")
public class DownloadProductImgController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("filename");
		String location = "C:\\Users\\84168\\Desktop\\JAVA_WEB\\PhoneWorld\\WebContent\\static\\admin\\image";
		
		File file = new File(location + File.separator + fileName);
		
		if(file.exists()) {
			FileUtils.copyFile(file, resp.getOutputStream());
		}
	}
}
