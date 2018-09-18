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
 * 自定义的HttpFilter，实现自Filter接口
 * 优化后的Filter接口，不是必须的方法，在这个接口中进行了优化，在实现类中可以省略。
 */
public abstract class HttpFilter implements Filter {
	
	/**
	 * 用于保存FilterConfig对象
	 */
	private FilterConfig filterConfig;
	
	/**
	 * 不建议子类直接覆盖，若直接覆盖，将可能导致FilterConfig成员变量初始化失败。
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	/**
	 * 供子类继承的初始化方法，可以通过getFilterConfig()获取FilterConfig对象：
	 */
	protected void init() {}
	
	/**
	 * 直接返回init(FilterConfig)的FilterConfig对象
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	/**
	 * 原生的doFilter方法，在方法内部把 ServletRequest 和 ServletResponse
	 * 转为了HttpServletRequest 和 HttpServletResponse；并调用了 
	 * doFilter(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain)
	 * 
	 * 若编写Filter的过滤方法，不建议直接继承该方法，而建议继承 doFilter(HttpServletRequest request, HttpServletResponse response,
	 *	FilterChain filterChain)方法
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		doFilter(request, response, chain);
	}
	
	/**
	 * 抽象方法，为Http请求定制，必须实现的方法
	 * 好处：拿到的就是HttpServletRequest request, HttpServletResponse response
	 */
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)throws IOException, ServletException;
	
	/**
	 * 空的destroy()方法
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
