package com.llm.a05tag.a01.customtag;
/**
 * 自定义标签:把标签体内容转换为大写, 并输出 time 次到浏览器上:
 *  <atllm:printUpper time="10">abcdefg</atllm> 
 */

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUppercaseTag5 extends SimpleTagSupport {
	
//	标签的属性：time
	private String time;
	public void setTime(String time) {
		this.time = time;
	}
	
//	标签体：
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
