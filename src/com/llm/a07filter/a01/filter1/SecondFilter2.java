package com.llm.a07filter.a01.filter1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter������������ѧϰ
 */
public class SecondFilter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Second init~~~");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1. Before SecondFilter chain.doFilter...");
		
//		���У�
		chain.doFilter(request, response);
		
		System.out.println("2. After SecondFilter chain.doFilter...");
	}

	@Override
	public void destroy() {
		System.out.println("Second destroy~~~");
	}
}
