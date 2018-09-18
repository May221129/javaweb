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
 * Ҫ���web.xml�е�����һ�𿴣�����
 */
public class HelloFilter1 implements Filter {

	/**
	 * init()��������Filter������֮�����������ã���ֻ����һ��
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Hello init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3. Before HelloFilter chain.doFilter...");
		
//		���У�
		chain.doFilter(request, response);
		
		System.out.println("4. After HelloFilter chain.doFilter...");
	}

	@Override
	public void destroy() {
		System.out.println("Hello destroy...");
	}
}
