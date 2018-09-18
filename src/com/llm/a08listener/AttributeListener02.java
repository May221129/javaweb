package com.llm.a08listener;
/**
 * ����������Եı����ʵ��������;
 * ��������ServletContext��HttpSession��HttpServletRequest�����������е����Ա����Ϣʱ��ļ�������
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
		System.out.println("��request�������һ������:" + srae.getName() + ":" + srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("��request��ɾ����һ������:" + srae.getName() + ":" + srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("��request���滻��һ������:" + srae.getName() + ":" + srae.getValue());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("��sessiont�������һ�����ԡ�");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("��session��ɾ����һ�����ԡ�");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("��session�и�����һ�����ԡ�");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("��ServletContext�������һ�����ԡ�");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("��ServletContext��ɾ����һ�����ԡ�");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("��ServletContext�и�����һ�����ԡ�");
	}
}
