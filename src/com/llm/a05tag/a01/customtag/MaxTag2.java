package com.llm.a05tag.a01.customtag;
//�Զ����ǩ���Ƚ��������Ĵ�С
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ʵ��SimpleTag�ӿں��鷳����Ϊʵ�������кܶ෽�����ò���
 * �̳�SimpleTagSupport��ͻ���öࡣ
 */
public class MaxTag2 extends SimpleTagSupport {
	
	/**
	 * setXxx()���������ñ�ǩ���ԣ�ֻ�ж������Բŵ��ø÷���
	 * ���ڱ�ǩ���������ж��� setter ����. ��������е��������Ͷ�����Ϊ String ����
	 */
	private String number1;
	private String number2;
	//ͨ�������setValue()��setCount()���������Ի�������������Ҫ��tld�ļ������������ǰ�ı�ǩ����Щ����
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public void setNumber2(String number2){
		this.number2 = number2;
	}
	
//	doTag():ʵ�ʵı�ǩ���߼���д����������
	@Override
	public void doTag() throws JspException, IOException {
		
		int a = 0;
		int b = 0;
		
		PageContext pageContext = (PageContext) getJspContext();
		
		JspWriter out = pageContext.getOut();
		
//		�Ƚ�number1��number2�Ĵ�С��
		try {
			a = Integer.parseInt(number1);//parseInt():���ַ���ת��������
			b = Integer.parseInt(number2);
//			out.print(a > b ? a : b);//��ôд�����Ͻ������a=b�أ�
			if(a > b){
				out.print(a);
			}if(a < b){
				out.print(b);
			}if(a == b){
				out.print("����ֵ���");
			}
		} catch (Exception e) {
			out.print("��������Եĸ�ʽ����ȷ��");
		}
	}
}
