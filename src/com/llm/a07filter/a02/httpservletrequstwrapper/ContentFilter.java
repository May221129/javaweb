package com.llm.a07filter.a02.httpservletrequstwrapper;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import com.llm.a07filter.a01.filter1.HttpFilter;

public class ContentFilter extends HttpFilter{

    public void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)throws IOException, ServletException {
    	/*
    	 * 1. ��ȡ���� content ������ֵ
    	 * String content = request.getParameter("content");
    	 * 
    	 * 2. ������ fuck, shit ���ַ����滻��Ϊ ****
    	 * if(content.contains(" fuck ")){
    	 * 
    		 * SerletRequest, HttpServletRequest �в�û���ṩ���� setParameter(paramName, paramValue)
    		 * �����������ķ���.
    		 * 
    		 * Ŀ��: �ı� HttpServletRequest �� getParameter(String) ��������Ϊ: ���÷����ķ���ֵ�� 
    		 * ���� " fuck ", ���滻Ϊ " **** "
    		 * 
    		 * ̽���������ַ����ܹ�ʵ�֣�
    		 * 
    		 * 2.1  ������һ����ķ���������, ��Ҫ������д, ����ķ�ʽ��, �̳и���, ��д����. 
    		 * ��ʵ������Ҫ�̳� org.apache.catalina.connector.RequestFacade, 
    		 * ������� Tomcat��������ʵ��, ������������, �÷������޷�ʹ��. �� 
    		 * 
    		 * 2.2 ֱ��дһ�� HttpServletRequest �ӿڵ�ʵ����: �޷�ʵ���еķ���.
    		 * ��Ϊ��Ҫ���˽������������ô����ͷ������߶���ϡ���
    		 * 
    		 * 2.3  װ��Ŀǰ�� HttpServletRequest ����: װ���� getParameter ����, ����������������ʵ����ͬ.
    		 * ����һ����, ����ʵ�� HttpServletRequest �ӿ�, �ѵ�ǰ doFilter �е� request ���뵽������, 
    		 * ��Ϊ���Ա����, ʹ�øó�Ա����ȥʵ�ֽӿڵ�ȫ������. ����
    	*/
    	
    	//ʵ�ʵ�ʵ�֣�
    	HttpServletRequest req = new MyHttpServletRequest(request);
    	
    	//3. ת��Ŀ��ҳ��
    	filterChain.doFilter(req, response);
    }
}