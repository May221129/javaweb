package com.llm.a05tag.a01.customtag;
//�Զ����ǩ����ĳ����Ϣ���N��
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag1 implements SimpleTag {
	
	/**
	 * setXxx()���������ñ�ǩ���ԣ�ֻ�ж������Բŵ��ø÷���
	 * ���ڱ�ǩ���������ж��� setter ����. ��������е��������Ͷ�����Ϊ String ����
	 */
	private String value;
	private String count;
	//ͨ�������setValue()��setCount()���������Ի�������������Ҫ��tld�ļ������������ǰ�ı�ǩ����Щ����
	public void setValue(String value) {
		this.value = value;
	}
	public void setCount(String count){
		this.count = count;
	}
	
//	doTag():ʵ�ʵı�ǩ���߼���д����������
	@Override
	public void doTag() throws JspException, IOException {
//		System.out.println("value:" + value + "; count: " + count);
//		
//		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//		pageContext.getOut().print("Hello: " + request.getParameter("name"));//�����name����ͨ��URL����+��name=...������
		
		JspWriter out = pageContext.getOut();
		int count2 = 0;
		count2 = Integer.parseInt(count);//parseInt():���ַ���ת��������
		for(int i = 0; i < count2; i++){
			out.print((i+1) + ". " + value);
			out.print("<br>");
		}
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}
	
//	������3������Ӧ������Servlet������ò��Ұ���Ӧ���󴫽����ģ�
	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}
	
	private PageContext pageContext;
	
/** 
 * setJspBody()���������ã�
 * ͨ��JSP������ã���ʵ�ʴ���ǰJSPҳ���Context������������ʹ��һ����Ա����ȥ���ռ���
 * PageContext������ǵ�ǰJSPҳ�棬��PageContext�п��Ի�ȡ��������8����������
 * ���Է���JSPҳ��������ģ���ǩ��������������ɡ�
 */
	@Override
	public void setJspContext(JspContext arg0) {
//		PageContext��JspContext�����࣬ͨ���������д��룬��֤�����arg0��JSPContext����PageContext��
//		System.out.println(arg0 instanceof PageContext);
		this.pageContext = (PageContext) arg0;
	}
	
	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}
}
