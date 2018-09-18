package com.llm.a01base.a03thirdwebapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 是什么：针对Http协议定义的一个Servlet基类
 */
public class A03HttpServlet extends A02MyGenericServlet {

	/*
	 * 这是自己写的Service方法：
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
	 * 这是系统写好的Service方法，更加简洁
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
		
		//1.请求方式：
		String method = request.getMethod();
		
		//2.根据请求方式，再调动对应的处理方法：
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
