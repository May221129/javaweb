package com.llm.a05tag.a01.customtag;
/** 
 * ������ǩ���Զ����ǩ��
 * <c:choose>
 * 		<c:when test="${param.age > 24}">��ѧ��ҵ</c:when>
 * 		<c:when test="${param.age > 20}">���б�ҵ</c:when>
 * 		<c:otherwise>��������ѧ��...</c:otherwise>
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
