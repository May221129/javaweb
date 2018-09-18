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
		 * ���ʣ����������д��������Ϊʲô��ôд������ʲô���ã�
		 * ��һ�У���������������С������Ǹ���UserName��һ�����������Լ��õġ�
		 * �ڶ��У����벻������ʲô�����ᱨ����������ʦ�õģ�Ϊ����ʦ�Ĳ�����
		 */
		String initPassword = filterConfig.getInitParameter("password");
//		String initPassword = filterConfig.getServletContext().getInitParameter("password");
		
		String password = request.getParameter("password");
//		�����ʼ����password��Jsp�д���Ĳ���password����ȣ���ô�죺
		if(!initPassword.equals(password)){
			request.setAttribute("message", "���벻��ȷ");
			request.getRequestDispatcher("/a07filter_a01_filter1/login3.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}

}
