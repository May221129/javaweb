package com.llm.a05tag.a01.customtag;
//自定义标签：比较两个数的大小
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
 * 实现SimpleTag接口很麻烦，因为实现类中有很多方法都用不上
 * 继承SimpleTagSupport类就会简便得多。
 */
public class MaxTag2 extends SimpleTagSupport {
	
	/**
	 * setXxx()方法：设置标签属性，只有定义属性才调用该方法
	 * 先在标签处理器类中定义 setter 方法. 建议把所有的属性类型都设置为 String 类型
	 */
	private String number1;
	private String number2;
	//通过下面的setValue()和setCount()方法，属性还进不来，还需要在tld文件中描述清楚当前的标签有哪些属性
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public void setNumber2(String number2){
		this.number2 = number2;
	}
	
//	doTag():实际的标签体逻辑就写在这个方法里：
	@Override
	public void doTag() throws JspException, IOException {
		
		int a = 0;
		int b = 0;
		
		PageContext pageContext = (PageContext) getJspContext();
		
		JspWriter out = pageContext.getOut();
		
//		比较number1和number2的大小：
		try {
			a = Integer.parseInt(number1);//parseInt():将字符串转换成整数
			b = Integer.parseInt(number2);
//			out.print(a > b ? a : b);//这么写不够严谨，如果a=b呢？
			if(a > b){
				out.print(a);
			}if(a < b){
				out.print(b);
			}if(a == b){
				out.print("两个值相等");
			}
		} catch (Exception e) {
			out.print("输入的属性的格式不正确！");
		}
	}
}
