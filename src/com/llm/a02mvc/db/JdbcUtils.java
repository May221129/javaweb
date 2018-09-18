package com.llm.a02mvc.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

	/**
	 * JDBC�����Ĺ����ࣺ
	 */
public class JdbcUtils {
	
	/**
	 * �ͷ�Connection����
	 */	
	public static void releaseConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	ΪʲôDataSource��static����Ϊֻ������Դ��һ�ݼ��ɡ�
	private static DataSource dataSource = null;
	
//	(��̬�����ֻ��ִ��һ��)
//	ע�⣺����Դ�ĳ�ʼ��һ��Ҫ���ھ�̬������У���Ϊ����Դֻ�ܱ�����һ�Σ�
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 * ��������Դ��һ��Connection����
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

}
