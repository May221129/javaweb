package com.llm.a02mvc.dao.implement;

import java.util.List;
import com.llm.a02mvc.dao.A02CriteriaCustomer;
import com.llm.a02mvc.dao.A02CustomerDAO;
import com.llm.a02mvc.domain.Customer;

public class A02CustomerDAOXMLImplement implements A02CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(A02CriteriaCustomer cc) {
		System.out.println("getForListWithCriteriaCustomer");
		return null;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("save");
	}

	@Override
	public Customer get(Integer id) {
		System.out.println("get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");
	}

	@Override
	public void update(Customer customer) {
		System.out.println("update");
	}

	@Override
	public long getCountWithName(String name) {
		System.out.println("getCountWithName");  
		return 0;
	}
}
