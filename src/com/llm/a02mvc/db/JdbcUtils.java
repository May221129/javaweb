package com.llm.a02mvc.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

	/**
	 * JDBC操作的工具类：
	 */
public class JdbcUtils {
	
	/**
	 * 释放Connection连接
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
	
//	为什么DataSource是static？因为只想数据源有一份即可。
	private static DataSource dataSource = null;
	
//	(静态代码块只会执行一次)
//	注意：数据源的初始化一定要放在静态代码块中，因为数据源只能被创建一次！
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 * 返回数据源的一个Connection对象
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

}
