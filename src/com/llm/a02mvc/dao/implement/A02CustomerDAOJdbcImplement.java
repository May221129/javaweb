package com.llm.a02mvc.dao.implement;

import java.util.List;

import com.llm.a02mvc.dao.A02CriteriaCustomer;
import com.llm.a02mvc.dao.A02CustomerDAO;
import com.llm.a02mvc.dao.DAO;
import com.llm.a02mvc.domain.Customer;

public class A02CustomerDAOJdbcImplement extends DAO<Customer> implements A02CustomerDAO{

	public List<Customer> getForListWithCriteriaCustomer(A02CriteriaCustomer cc) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE " +
				"name LIKE ? AND address LIKE ? AND phone LIKE ?";
		//�޸��� CriteriaCustomer �� getter ����: ʹ�䷵�ص��ַ������� "%%".
		//������ֵΪ null �򷵻� "%%", ����Ϊ null, �򷵻� "%" + �ֶα�����ֵ + "%"
		return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
	}
	
	@Override
	public List<Customer> getAll() {
		String sql = "SELECT id, name, address, phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name, address, phone) VALUES(?,?,?)";
		update(sql, customer.getName(), customer.getAddress(), customer.getPhone()); 
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
		return get(sql, id); 
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM customers WHERE name = ?";
		return getForValue(sql, name); 
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customers SET name = ?, address = ?, phone = ? " +
				"WHERE id = ?";
		update(sql, customer.getName(), customer.getAddress(), 
				customer.getPhone(), customer.getId());
	}
}