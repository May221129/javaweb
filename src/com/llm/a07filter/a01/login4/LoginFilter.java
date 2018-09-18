package com.llm.a07filter.a01.login4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.llm.a07filter.a01.filter1.HttpFilter;

public class LoginFilter extends HttpFilter {

	// 1. web.xml中获取sessionKey，redirectUrl，uncheckedUrls:
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;

	@Override
	public void init() {

		ServletContext servletContext = getFilterConfig().getServletContext();

		sessionKey = servletContext.getInitParameter("userSessionKey");

		redirectUrl = servletContext.getInitParameter("redirectPage");

		// /a07filter_a01_login4/a.jsp,/a07filter_a01_login4/list.jsp,/a07filter_a01_login4/login.jsp,/a07filter_a01_login4/doLodin.jsp
		// 这里的 / 代表的并非是web应用的根目录
		uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 2. 获取请求的servletPath：下面三个都可以，但是最后一个简短的就够用了

		// http://localhost:8080/javaweb/a07filter_a01_login4/list.jsp :
		// String requestURL = request.getRequestURL().toString();

		// /javaweb/a07filter_a01_login4/list.jsp :
		// String requestURI = request.getRequestURI();

		// /a07filter_a01_login4/list.jsp :
		String servletPath = request.getServletPath();

		// 3.检查 1 获取的servletPath是否为web.xml中配置好的context-param中不需要检查的URL，
		// 若是，则直接放行，方法结束；
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		if (urls.contains(servletPath)) {
			filterChain.doFilter(request, response);
			return;
		}

		// 4.从session中获取sessionKey对应的值。若值不存在，则重定向到redirectURL
		Object user = request.getSession().getAttribute(sessionKey);
		if (user == null) {
			response.sendRedirect(request.getContextPath() + redirectUrl);
			return;
		}

		// 5.若值存在，则放行，允许访问。
		filterChain.doFilter(request, response);
	}
}
