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

	// 1. web.xml�л�ȡsessionKey��redirectUrl��uncheckedUrls:
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;

	@Override
	public void init() {

		ServletContext servletContext = getFilterConfig().getServletContext();

		sessionKey = servletContext.getInitParameter("userSessionKey");

		redirectUrl = servletContext.getInitParameter("redirectPage");

		// /a07filter_a01_login4/a.jsp,/a07filter_a01_login4/list.jsp,/a07filter_a01_login4/login.jsp,/a07filter_a01_login4/doLodin.jsp
		// ����� / ����Ĳ�����webӦ�õĸ�Ŀ¼
		uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 2. ��ȡ�����servletPath���������������ԣ��������һ����̵ľ͹�����

		// http://localhost:8080/javaweb/a07filter_a01_login4/list.jsp :
		// String requestURL = request.getRequestURL().toString();

		// /javaweb/a07filter_a01_login4/list.jsp :
		// String requestURI = request.getRequestURI();

		// /a07filter_a01_login4/list.jsp :
		String servletPath = request.getServletPath();

		// 3.��� 1 ��ȡ��servletPath�Ƿ�Ϊweb.xml�����úõ�context-param�в���Ҫ����URL��
		// ���ǣ���ֱ�ӷ��У�����������
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		if (urls.contains(servletPath)) {
			filterChain.doFilter(request, response);
			return;
		}

		// 4.��session�л�ȡsessionKey��Ӧ��ֵ����ֵ�����ڣ����ض���redirectURL
		Object user = request.getSession().getAttribute(sessionKey);
		if (user == null) {
			response.sendRedirect(request.getContextPath() + redirectUrl);
			return;
		}

		// 5.��ֵ���ڣ�����У�������ʡ�
		filterChain.doFilter(request, response);
	}
}
