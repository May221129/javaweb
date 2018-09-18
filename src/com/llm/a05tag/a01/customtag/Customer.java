package com.llm.a05tag.a01.customtag;
/**
 * 体验<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>标签库
 * <c:forEach></c:forEach>标签:遍历集合
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
