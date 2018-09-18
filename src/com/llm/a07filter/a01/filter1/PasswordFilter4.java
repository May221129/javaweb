package com.llm.a07filter.a01.filter1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PasswordFilter4 implements Filter {
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 提问：下面这两行代码的区别：为什么这么写？产生什么作用？
		 * 第一行：程序可以正常运行。这行是根据UserName类一样的做法，自己敲的。
		 * 第二行：密码不论输入什么，都会报错。这行是老师敲的，为何老师的不报错？
		 */
		String initPassword = filterConfig.getInitParameter("password");
//		String initPassword = filterConfig.getServletContext().getInitParameter("password");
		
		String password = request.getParameter("password");
//		如果初始化的password和Jsp中传入的参数password不相等，怎么办：
		if(!initPassword.equals(password)){
			request.setAttribute("message", "密码不正确");
			request.getRequestDispatcher("/a07filter_a01_filter1/login3.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}

}
