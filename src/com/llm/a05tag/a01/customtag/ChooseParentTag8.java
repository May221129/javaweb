package com.llm.a05tag.a01.customtag;
/** 
 * 带父标签的自定义标签：
 * <c:choose>
 * 		<c:when test="${param.age > 24}">大学毕业</c:when>
 * 		<c:when test="${param.age > 20}">高中毕业</c:when>
 * 		<c:otherwise>高中以下学历...</c:otherwise>
 * </c:choose>
 */

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseParentTag8 extends SimpleTagSupport {
	private boolean flag = true;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag(){
		return flag;
	}
	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
}
