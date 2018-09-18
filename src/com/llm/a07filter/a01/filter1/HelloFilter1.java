package com.llm.a07filter.a01.filter1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter过滤器的入门学习
 * 要结合web.xml中的配置一起看！！！
 */
public class HelloFilter1 implements Filter {

	/**
	 * init()方法：在Filter被创建之后立即被调用，且只调用一次
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Hello init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3. Before HelloFilter chain.doFilter...");
		
//		放行：
		chain.doFilter(request, response);
		
		System.out.println("4. After HelloFilter chain.doFilter...");
	}

	@Override
	public void destroy() {
		System.out.println("Hello destroy...");
	}
}
