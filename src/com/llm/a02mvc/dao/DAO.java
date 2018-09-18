package com.llm.a02mvc.dao;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.llm.a02mvc.db.JdbcUtils;
import com.llm.a02mvc.utils.ReflectionUtils;

/**
 * ��װ�˻�����CRUD�ķ������Թ�����̳�ʹ�á�
 * ��ǰDAOû������ֱ���ڷ����л�ȡ���ݿ����ӡ�
 * ����DAO��ȡDBUtils���������
 * @param <T>:��ǰDAO�����ʵ�����������ʲô
 */
public class DAO<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
//	�õ������������Class��
	private Class<T> clazz;
	
	public DAO() {
		
		clazz = ReflectionUtils.getSuperGenericType(getClass());
		
		/*
		System.out.println("DAO's construtor...");
		System.out.println(this.toString()); //A02CustomerDAOJdbcImplement
		
		Class clazz2 = this.getClass(); //A02CustomerDAOJdbcImplement.class
		System.out.println(clazz2); 		
		
		//com.atguigu.mvcapp.dao.DAO û��ϣ���ķ��Ͳ���
		Class clazz3 = this.getClass().getSuperclass();
		System.out.println(clazz3); 
		
		//DAO<Customer>
		Type type = this.getClass().getGenericSuperclass();
		System.out.println(type); 
		
		//true
		System.out.println(type instanceof ParameterizedType); 
		
		//[class com.atguigu.mvcapp.domain.Customer]
		ParameterizedType type2 = (ParameterizedType) type;
		Type [] typeArgs = type2.getActualTypeArguments();
		System.out.println(Arrays.asList(typeArgs)); 
		
		//class com.atguigu.mvcapp.domain.Customer
		Type typeArg = typeArgs[0];
		System.out.println(typeArg);
		
		System.out.println(typeArg instanceof Class);
		
		if(typeArg instanceof Class){
			clazz = (Class<T>) typeArg;
		}
		*/
	}
	
	/**
	 * ����ĳһ���ֶε�ֵ��
	 * ���緵��ĳһ����¼��customerName�����߷������ݱ����ж�������¼�ȡ�
	 */
	public <E> E getForValue(String sql, Object ... args){
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);  
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * ����T����Ӧ��List
	 */
	public List<T> getForList(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * ���ض�Ӧ�� T ��һ��ʵ����Ķ���
	 */
	public T get(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * �÷�����װ��INSERT��UPTATE����
	 * @param aql��SQL��䡣
	 * @param args�����SQL����ռλ����
	 */
	public void update(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.releaseConnection(connection);
		}
	}
}
