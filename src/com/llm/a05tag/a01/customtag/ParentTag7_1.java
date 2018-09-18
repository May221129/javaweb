package com.llm.a05tag.a01.customtag;
/**
 * 自定义标签：父标签
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
		System.out.println("父标签的处理器类name：" + name);
//		有标签体：输出到jsp页面（子标签作为父标签的标签体）
		getJspBody().invoke(null);
	}
}
