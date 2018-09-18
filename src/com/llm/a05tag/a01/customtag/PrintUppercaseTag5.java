package com.llm.a05tag.a01.customtag;
/**
 * �Զ����ǩ:�ѱ�ǩ������ת��Ϊ��д, ����� time �ε��������:
 *  <atllm:printUpper time="10">abcdefg</atllm> 
 */

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUppercaseTag5 extends SimpleTagSupport {
	
//	��ǩ�����ԣ�time
	private String time;
	public void setTime(String time) {
		this.time = time;
	}
	
//	��ǩ�壺
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment bodyContent = getJspBody();
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		String content = sw.toString().toUpperCase();
		int time2 = 0;
		try {
			time2 = Integer.parseInt(time);
		} catch (Exception e) {}
		for(int i = 0; i < time2; i++){
			getJspContext().getOut().print((i+1) + ": " + content + "<br>");
		}
	}
}
