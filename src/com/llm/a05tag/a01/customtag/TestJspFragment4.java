package com.llm.a05tag.a01.customtag;
/**
 * 自定义标签：带标签体的自定义标签
 * 格式如：<atllm:testJspFragment>HelloWorld!!!</atllm:testJspFragment>
 * 这里要实现的功能：把JSP页面里的标签体都变成大写字母，实现步骤如下：
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
 * 提问：getJspBody()方法返回一个JspFragment对象，这个JspFragment对象是怎么获得的？
 * 答：情况一： SimpleTagSupport类实现了setJspBody(JspFragment jspBody)方法，
 * 		并且定义了getJspBody()方法返回Jsp Fragment对象。
 * 	     情况二： SimpleTag接口有一个setJspBody(JspFragment jspBody),
 * 		若在tld配置文件中配置了标签是有标签体的，JSP引擎就会自动调用这个方法，
 * 		把标签体对应的Jsp Fragment对象传到这个标签处理器类里。
 */	
		JspFragment badyContent = getJspBody();
		
/**
 * JspFragment.invoke(Writer out):Writer即为标签体内容输出的字符流，
 * 若Writer为null，则输出到getJspContext().getOut(),即输出到页面上。
 */
				
//		1. 利用StringWriter得到标签体的内容：
		StringWriter sw = new StringWriter();
		badyContent.invoke(sw);
		
//		2. 把标签体的内容都变为大写字母：
		String content = sw.toString().toUpperCase();
		
//		3. 获取JSP页面的out隐含对象，输出到页面上：
		getJspContext().getOut().print(content);
		
//		4. 输出到控制台上：
		System.out.println(content);
	}
}