package com.llm.a08listener;
/**
 * ���������Ĵ��������ٵļ�������ServletContextListener, HttpSessionListener, ServletRequestListener
 * ��������ServletContext��HttpSession��HttpServletRequest����������Ĵ����������¼��ļ�������
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//һ�������ʵ�ֶ���ӿڣ�
public class Listener01 implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext���󱻴���..." + sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext��������..." + sce.getServletContext());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest�������٣�����" + sre.getServletRequest());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest���󱻴���������" + sre.getServletRequest());
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession ���󱻴���~~~" + se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession ��������~~~" + se.getSession());
	}
}
