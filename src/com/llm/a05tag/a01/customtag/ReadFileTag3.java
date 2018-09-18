package com.llm.a05tag.a01.customtag;
//�Զ����ǩ���������ָ���ļ�������

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFileTag3 extends SimpleTagSupport{
	
//	����ڵ�ǰWEBӦ�ø�·�����ļ���
	private String src;
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * BufferedReader ��Reader����չ�������ṩͨ�õĻ��巽ʽ�ı���ȡ�������ṩ�˺�ʵ�õ�readLine����ȡһ���ı��У����ַ��������ж�ȡ�ı�����������ַ����Ӷ��ṩ�ַ���������еĸ�Ч��ȡ��
	 * һ���÷���
	 * BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ming.txt")));
	 * String data = null;
	 * while((data = br.readLine())!=null) { System.out.println(data); }
	 */	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		InputStream in = pageContext.getServletContext().getResourceAsStream(src);
		BufferedReader reader  = new BufferedReader(new InputStreamReader(in));
		String str = null;
		
//		 һ��һ�еĶ����ǵû���.
		while((str = reader.readLine()) != null){
			
//			����ļ��������б�ǩ������Ҫת��һ�£�����HTML��ȡ�������ǩʱ���ᵱ��һ��ı�ǩ������������ҳ���ϴ�ӡ����
//			 �������� < �� > ��Ҫת��һ��
//			���������ʹ��������ʽ��
			str = Pattern.compile("<").matcher(str).replaceAll("&lt");
			str = Pattern.compile(">").matcher(str).replaceAll("&gt");
			
			pageContext.getOut().println(str);
			pageContext.getOut().println("<br>");
		}
	}
}
