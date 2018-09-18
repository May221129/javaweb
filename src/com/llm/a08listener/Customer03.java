package com.llm.a08listener;
import java.io.Serializable;

/**
 * 感知Session绑定的事件监听器：HttpSessionBindingListener
 * 感知Seesion被活化或钝化的监听器：HttpSessionActivationListener
 * > 活化: 从磁盘中读取 session 对象
 * > 钝化: 向磁盘中写入 session 对象
 * 注：实现序列化：继承Serializable接口
 */
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer03 implements HttpSessionBindingListener, HttpSessionActivationListener,Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("绑定到Session");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("从Session中解除绑定");
		
		Object value = event.getValue();
		System.out.println(value == this);
		System.out.println(event.getName());
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("从内存中写到磁盘上...");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("从磁盘中读取出来...");
	}
}
