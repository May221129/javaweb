package com.llm.a08listener;
/**
 * 域对象中属性的变更的实践监听器;
 * 用来监听ServletContext、HttpSession、HttpServletRequest这三个对象中的属性变更信息时间的监听器。
 */
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener02
		implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("向request中添加了一个属性:" + srae.getName() + ":" + srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("从request中删除了一个属性:" + srae.getName() + ":" + srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("从request中替换了一个属性:" + srae.getName() + ":" + srae.getValue());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("向sessiont中添加了一个属性。");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("从session中删除了一个属性。");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("从session中更换了一个属性。");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("向ServletContext中添加了一个属性。");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("从ServletContext中删除了一个属性。");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("从ServletContext中更换了一个属性。");
	}
}
