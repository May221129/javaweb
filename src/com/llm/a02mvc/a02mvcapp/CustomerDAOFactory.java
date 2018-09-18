package com.llm.a02mvc.a02mvcapp;

import java.util.HashMap;
import java.util.Map;
import com.llm.a02mvc.dao.A02CustomerDAO;
import com.llm.a02mvc.dao.implement.A02CustomerDAOJdbcImplement;
import com.llm.a02mvc.dao.implement.A02CustomerDAOXMLImplement;

public class CustomerDAOFactory {
	
	private Map<String, A02CustomerDAO> daos = new HashMap<String, A02CustomerDAO>();
	
	
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstance() {
		return instance;
	}
	
	private String type = null;
	
	public void setType(String type) {
		this.type = type;
	}
	
	private CustomerDAOFactory(){
		daos.put("jdbc", new A02CustomerDAOJdbcImplement());
		daos.put("xml", new A02CustomerDAOXMLImplement());
	}
	
	public A02CustomerDAO getCustomerDAO(){
		return daos.get(type);
	}	
}
