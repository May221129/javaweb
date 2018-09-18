package com.llm.a08listener;
import java.io.Serializable;

/**
 * ��֪Session�󶨵��¼���������HttpSessionBindingListener
 * ��֪Seesion�����ۻ��ļ�������HttpSessionActivationListener
 * > �: �Ӵ����ж�ȡ session ����
 * > �ۻ�: �������д�� session ����
 * ע��ʵ�����л����̳�Serializable�ӿ�
 */
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer03 implements HttpSessionBindingListener, HttpSessionActivationListener,Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("�󶨵�Session");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("��Session�н����");
		
		Object value = event.getValue();
		System.out.println(value == this);
		System.out.println(event.getName());
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("���ڴ���д��������...");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("�Ӵ����ж�ȡ����...");
	}
}
