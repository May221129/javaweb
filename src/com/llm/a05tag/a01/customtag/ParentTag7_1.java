package com.llm.a05tag.a01.customtag;
/**
 * �Զ����ǩ������ǩ
 */

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag7_1 extends SimpleTagSupport {
	
	private String name = "tomorrow~~~";
	public String getName() {
		return name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("����ǩ�Ĵ�������name��" + name);
//		�б�ǩ�壺�����jspҳ�棨�ӱ�ǩ��Ϊ����ǩ�ı�ǩ�壩
		getJspBody().invoke(null);
	}
}
