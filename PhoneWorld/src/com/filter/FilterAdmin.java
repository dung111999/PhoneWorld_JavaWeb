package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;

@WebFilter(urlPatterns = {"/admin/*"})
public class FilterAdmin implements Filter {
	
	@Override
	public void destroy() {
	
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession httpSession = req.getSession();
		
		Object userObj = httpSession.getAttribute("admin");
		if(userObj != null) {
			arg2.doFilter(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin-tp/user/login");
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
