package com.llm.a07filter.a01.cache2;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llm.a07filter.a01.filter1.HttpFilter;

/**
 * ���û�����ࡣ
 * ��˳������Զ���ĳ�����HttpFilter�����̳�֮��ʲô�����Ǳ���ʵ�ֵġ���
 */
@WebFilter("/a07filter_a01_cache2/*")
public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("NoCacheFilter's doFilter...");
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no=cache");
		
//		һ��������д�������д��룺
		filterChain.doFilter(request, response);
	}
}
