package com.llm.a07filter.a01.encoding3;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.llm.a07filter.a01.filter1.HttpFilter;

public class EncodingFilter extends HttpFilter {

	// �ַ����벻�䣬������Ҫдһ����Ա������
	private String encoding;

	@Override
	public void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");

	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// �ڿ���̨�����������������÷����Ƿ���ִ�У�
		// System.out.println("Encoding's " + encoding);

		// ����ֱ������д����д��
		// request.setCharacterEncoding("UTF-8");
		/**
		 * �����encoding��������и�ֵ/��ʼ���ģ�
		 * web.xml�У����ø�EncodingFilter��������ʱ��
		 */
		request.setCharacterEncoding(encoding);

		filterChain.doFilter(request, response);
	}

}
