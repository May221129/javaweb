package com.llm.a05tag.a01.customtag;
/**
 * �Զ����ǩ������ǩ����Զ����ǩ
 * ��ʽ�磺<atllm:testJspFragment>HelloWorld!!!</atllm:testJspFragment>
 * ����Ҫʵ�ֵĹ��ܣ���JSPҳ����ı�ǩ�嶼��ɴ�д��ĸ��ʵ�ֲ������£�
 */

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment4 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		
/** 
 * ���ʣ�getJspBody()��������һ��JspFragment�������JspFragment��������ô��õģ�
 * �����һ�� SimpleTagSupport��ʵ����setJspBody(JspFragment jspBody)������
 * 		���Ҷ�����getJspBody()��������Jsp Fragment����
 * 	     ������� SimpleTag�ӿ���һ��setJspBody(JspFragment jspBody),
 * 		����tld�����ļ��������˱�ǩ���б�ǩ��ģ�JSP����ͻ��Զ��������������
 * 		�ѱ�ǩ���Ӧ��Jsp Fragment���󴫵������ǩ���������
 */	
		JspFragment badyContent = getJspBody();
		
/**
 * JspFragment.invoke(Writer out):Writer��Ϊ��ǩ������������ַ�����
 * ��WriterΪnull���������getJspContext().getOut(),�������ҳ���ϡ�
 */
				
//		1. ����StringWriter�õ���ǩ������ݣ�
		StringWriter sw = new StringWriter();
		badyContent.invoke(sw);
		
//		2. �ѱ�ǩ������ݶ���Ϊ��д��ĸ��
		String content = sw.toString().toUpperCase();
		
//		3. ��ȡJSPҳ���out�������������ҳ���ϣ�
		getJspContext().getOut().print(content);
		
//		4. ���������̨�ϣ�
		System.out.println(content);
	}
}