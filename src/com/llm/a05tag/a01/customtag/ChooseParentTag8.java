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
