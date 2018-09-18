package com.llm.a07filter.a01.filter1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �Զ����HttpFilter��ʵ����Filter�ӿ�
 * �Ż����Filter�ӿڣ����Ǳ���ķ�����������ӿ��н������Ż�����ʵ�����п���ʡ�ԡ�
 */
public abstract class HttpFilter implements Filter {
	
	/**
	 * ���ڱ���FilterConfig����
	 */
	private FilterConfig filterConfig;
	
	/**
	 * ����������ֱ�Ӹ��ǣ���ֱ�Ӹ��ǣ������ܵ���FilterConfig��Ա������ʼ��ʧ�ܡ�
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	/**
	 * ������̳еĳ�ʼ������������ͨ��getFilterConfig()��ȡFilterConfig����
	 */
	protected void init() {}
	
	/**
	 * ֱ�ӷ���init(FilterConfig)��FilterConfig����
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	/**
	 * ԭ����doFilter�������ڷ����ڲ��� ServletRequest �� ServletResponse
	 * תΪ��HttpServletRequest �� HttpServletResponse���������� 
	 * doFilter(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain)
	 * 
	 * ����дFilter�Ĺ��˷�����������ֱ�Ӽ̳и÷�����������̳� doFilter(HttpServletRequest request, HttpServletResponse response,
	 *	FilterChain filterChain)����
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		doFilter(request, response, chain);
	}
	
	/**
	 * ���󷽷���ΪHttp�����ƣ�����ʵ�ֵķ���
	 * �ô����õ��ľ���HttpServletRequest request, HttpServletResponse response
	 */
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)throws IOException, ServletException;
	
	/**
	 * �յ�destroy()����
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
