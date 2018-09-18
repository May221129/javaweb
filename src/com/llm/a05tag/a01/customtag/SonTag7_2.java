package com.llm.a05tag.a01.customtag;
/**
 * 自定义标签：子标签
 */

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag7_2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
//		1. 得到父标签的引用
		JspTag parent = getParent();
		ParentTag7_1 parentTag = (ParentTag7_1) parent;
		
//		2. 获取父标签的name属性
		String name = parentTag.getName();
		
//		3.把name值打印到jsp页面上
		getJspContext().getOut().print("子标签输出name： " + name);
	}
}
