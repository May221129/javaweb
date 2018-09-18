package com.llm.a08listener;
/**
 * 监听域对象的创建和销毁的监听器：ServletContextListener, HttpSessionListener, ServletRequestListener
 * 用来监听ServletContext、HttpSession、HttpServletRequest这三个对象的创建和销毁事件的监听器。
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//一个类可以实现多个接口：
public class Listener01 implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext对象被创建..." + sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext对象被销毁..." + sce.getServletContext());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest对象被销毁！！！" + sre.getServletRequest());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest对象被创建！！！" + sre.getServletRequest());
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession 对象被创建~~~" + se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession 对象被销毁~~~" + se.getSession());
	}
}
