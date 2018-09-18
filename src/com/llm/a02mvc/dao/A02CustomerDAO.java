package com.llm.a02mvc.dao;

import java.util.List;

import com.llm.a02mvc.domain.Customer;

public interface A02CustomerDAO {
	
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
/**
 * ���غ�name��ȵļ�¼����
 */
	public long getCountWithName(String name);

	public List<Customer> getForListWithCriteriaCustomer(A02CriteriaCustomer cc);

	public void update(Customer customer);
}
