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
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenSonTag8 extends SimpleTagSupport {
	
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			ChooseParentTag8 chooseParentTag = (ChooseParentTag8) getParent();
			if(chooseParentTag.getFlag()){
				getJspBody().invoke(null);
				chooseParentTag.setFlag(false);
			}
		}
	}
}
