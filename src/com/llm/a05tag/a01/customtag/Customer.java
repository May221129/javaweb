package com.llm.a05tag.a01.customtag;
/**
 * ����<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>��ǩ��
 * <c:forEach></c:forEach>��ǩ:��������
 * 
 *
 */

public class Customer {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Customer() {
		
	}
	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
