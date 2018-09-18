package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ʲô�����HttpЭ�鶨���һ��Servlet����
 */
public class A03HttpServlet extends A02MyGenericServlet {

	/*
	 * �����Լ�д��Service������
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if(request instanceof HttpServletRequest){
			HttpServletRequest httpServlerRequest = (HttpServletRequest)request;
			
			if(response instanceof HttpServletResponse){
				HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			}
			
			service(request, response);
		}
	}
	
	/*
	 * ����ϵͳд�õ�Service���������Ӽ��
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {

        HttpServletRequest  request;
        HttpServletResponse response;

        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) res;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        service(request, response);
    }
	*/
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.����ʽ��
		String method = request.getMethod();
		
		//2.��������ʽ���ٵ�����Ӧ�Ĵ�������
		if("GET".equalsIgnoreCase(method)){
			doGet(request, response);
		}else if("POSE".equalsIgnoreCase(method)){
			doPost(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
