package com.llm.a05tag.a01.customtag;
/**
 * �Զ����ǩ��ʵ��forEach��ǩ���������ϣ�
 */

import java.io.IOException;
import java.util.Collection;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag6 extends SimpleTagSupport {
	
//	��ǩ���ԣ�
	private Collection<?> items;
	private String var;
	public void setItems(Collection<?> items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
//		�� ���� items ��Ӧ�ļ���
		if(items != null){
			for(Object obj : items){
//				�� �����ڱ����Ķ�����뵽 pageContext ��, ��: var, ֵ: ���ڱ����Ķ���. 
				getJspContext().setAttribute(var, obj);
//				�� �ѱ�ǩ�������ֱ�������ҳ����:
				getJspBody().invoke(null);
			}
		}	
	}
}
