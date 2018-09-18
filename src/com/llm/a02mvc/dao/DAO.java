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
 * 封装了基本的CRUD的方法，以供子类继承使用。
 * 当前DAO没有事务，直接在方法中获取数据库连接。
 * 整个DAO采取DBUtils解决方法。
 * @param <T>:当前DAO处理的实体类的类型是什么
 */
public class DAO<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
//	得到描述整个类的Class：
	private Class<T> clazz;
	
	public DAO() {
		
		clazz = ReflectionUtils.getSuperGenericType(getClass());
		
		/*
		System.out.println("DAO's construtor...");
		System.out.println(this.toString()); //A02CustomerDAOJdbcImplement
		
		Class clazz2 = this.getClass(); //A02CustomerDAOJdbcImplement.class
		System.out.println(clazz2); 		
		
		//com.atguigu.mvcapp.dao.DAO 没有希望的泛型参数
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
	 * 返回某一个字段的值，
	 * 例如返回某一条记录的customerName，或者返回数据表中有多少条记录等。
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
	 * 返回T所对应的List
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
	 * 返回对应的 T 的一个实体类的对象。
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
	 * 该方法封装了INSERT，UPTATE操作
	 * @param aql：SQL语句。
	 * @param args：填充SQL语句的占位符。
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
