package com.llm.a07filter.a01.encoding3;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.llm.a07filter.a01.filter1.HttpFilter;

public class EncodingFilter extends HttpFilter {

	// 字符编码不变，所以需要写一个成员变量：
	private String encoding;

	@Override
	public void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");

	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 在控制台上输出这个方法，看该方法是否有执行：
		// System.out.println("Encoding's " + encoding);

		// 不能直接这样写，会写死
		// request.setCharacterEncoding("UTF-8");
		/**
		 * 这里的encoding是哪里进行赋值/初始化的？
		 * web.xml中，配置该EncodingFilter过滤器的时候。
		 */
		request.setCharacterEncoding(encoding);

		filterChain.doFilter(request, response);
	}

}
