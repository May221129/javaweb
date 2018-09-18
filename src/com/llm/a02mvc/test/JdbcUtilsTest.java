package com.llm.a02mvc.test;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import com.llm.a02mvc.db.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}
}
