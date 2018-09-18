package com.llm.a07filter.a01.filter1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserNameFilter3 implements Filter {
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String initUser = filterConfig.getInitParameter("username");
		String username = request.getParameter("username");
		if(!initUser.equals(username)){
			request.setAttribute("message", "用户名不正确");
			request.getRequestDispatcher("/a07filter_a01_filter1/login3.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}

}
