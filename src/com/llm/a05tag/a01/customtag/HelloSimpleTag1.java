package com.llm.a05tag.a01.customtag;
//自定义标签：将某个信息输出N遍
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag1 implements SimpleTag {
	
	/**
	 * setXxx()方法：设置标签属性，只有定义属性才调用该方法
	 * 先在标签处理器类中定义 setter 方法. 建议把所有的属性类型都设置为 String 类型
	 */
	private String value;
	private String count;
	//通过下面的setValue()和setCount()方法，属性还进不来，还需要在tld文件中描述清楚当前的标签有哪些属性
	public void setValue(String value) {
		this.value = value;
	}
	public void setCount(String count){
		this.count = count;
	}
	
//	doTag():实际的标签体逻辑就写在这个方法里：
	@Override
	public void doTag() throws JspException, IOException {
//		System.out.println("value:" + value + "; count: " + count);
//		
//		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//		pageContext.getOut().print("Hello: " + request.getParameter("name"));//这里的name可以通过URL后面+？name=...来传入
		
		JspWriter out = pageContext.getOut();
		int count2 = 0;
		count2 = Integer.parseInt(count);//parseInt():将字符串转换成整数
		for(int i = 0; i < count2; i++){
			out.print((i+1) + ". " + value);
			out.print("<br>");
		}
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}
	
//	下面这3个方法应该是由Servlet引擎调用并且把相应对象传进来的：
	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}
	
	private PageContext pageContext;
	
/** 
 * setJspBody()方法的作用：
 * 通过JSP引擎调用，把实际代表当前JSP页面的Context传进来。我们使用一个成员变量去接收即可
 * PageContext代表的是当前JSP页面，从PageContext中可以获取到其他的8个隐含对象
 * 所以凡是JSP页面可以做的，标签处理器都可以完成。
 */
	@Override
	public void setJspContext(JspContext arg0) {
//		PageContext是JspContext的子类，通过下面这行代码，验证传入的arg0是JSPContext还是PageContext：
//		System.out.println(arg0 instanceof PageContext);
		this.pageContext = (PageContext) arg0;
	}
	
	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}
}
