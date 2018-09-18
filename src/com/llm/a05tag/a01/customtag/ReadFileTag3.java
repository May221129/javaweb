package com.llm.a05tag.a01.customtag;
//自定义标签：用于输出指定文件的内容

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFileTag3 extends SimpleTagSupport{
	
//	相对于当前WEB应用根路径的文件名
	private String src;
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * BufferedReader 由Reader类扩展而来，提供通用的缓冲方式文本读取，而且提供了很实用的readLine，读取一个文本行，从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取。
	 * 一般用法：
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
		
//		 一行一行的读，记得换行.
		while((str = reader.readLine()) != null){
			
//			如果文件的内容有标签，则需要转换一下，否则HTML读取到这个标签时，会当做一般的标签处理，而不会在页面上打印出来
//			 即：遇到 < 和 > 需要转换一下
//			解决方法：使用正则表达式：
			str = Pattern.compile("<").matcher(str).replaceAll("&lt");
			str = Pattern.compile(">").matcher(str).replaceAll("&gt");
			
			pageContext.getOut().println(str);
			pageContext.getOut().println("<br>");
		}
	}
}
