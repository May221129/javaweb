package com.llm.a02mvc.test;

import java.util.List;
import org.junit.Test;
import com.llm.a02mvc.dao.A02CriteriaCustomer;
import com.llm.a02mvc.dao.A02CustomerDAO;
import com.llm.a02mvc.dao.implement.A02CustomerDAOJdbcImplement;
import com.llm.a02mvc.domain.Customer;

public class CustomerDAOJdbcImplementTest {

	private A02CustomerDAO customerDAO = 
			new A02CustomerDAOJdbcImplement();
	
	@Test
	public void testGetForListWithCriteriaCustomer(){
		A02CriteriaCustomer cc = new A02CriteriaCustomer("k", null, null);
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		System.out.println(customers); 
	}
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers); 
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setAddress("Shenzhen");
		customer.setName("lisi");
		customer.setPhone("12341234");
		
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDAO.get(3);
		System.out.println(cust); 
	}

	@Test
	public void testDelete() {
		customerDAO.delete(1);
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDAO.getCountWithName("Jerry");
		System.out.println(count); 
	}

}
