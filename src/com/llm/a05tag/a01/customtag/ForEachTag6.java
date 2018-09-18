package com.llm.a05tag.a01.customtag;
/**
 * 自定义标签：实现forEach标签（遍历集合）
 */

import java.io.IOException;
import java.util.Collection;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag6 extends SimpleTagSupport {
	
//	标签属性：
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
//		① 遍历 items 对应的集合
		if(items != null){
			for(Object obj : items){
//				② 把正在遍历的对象放入到 pageContext 中, 键: var, 值: 正在遍历的对象. 
				getJspContext().setAttribute(var, obj);
//				③ 把标签体的内容直接输出到页面上:
				getJspBody().invoke(null);
			}
		}	
	}
}
