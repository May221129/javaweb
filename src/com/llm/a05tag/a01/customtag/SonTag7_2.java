package com.llm.a05tag.a01.customtag;
/**
 * �Զ����ǩ���ӱ�ǩ
 */

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag7_2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
//		1. �õ�����ǩ������
		JspTag parent = getParent();
		ParentTag7_1 parentTag = (ParentTag7_1) parent;
		
//		2. ��ȡ����ǩ��name����
		String name = parentTag.getName();
		
//		3.��nameֵ��ӡ��jspҳ����
		getJspContext().getOut().print("�ӱ�ǩ���name�� " + name);
	}
}
