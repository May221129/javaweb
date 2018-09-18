package com.llm.a01base.a03thirdwebapp;
/**
	练习：和数据库进行交互
	在 MySQL 数据库中创建一个 test_users 数据表, 添加 3 个字段: id, user, password. 并录入几条记录. 
	定义一个 login.html, 里边定义两个请求字段: user, password. 发送请求到 loginServlet
	再创建一个 LoginServlet(需要继承自 HttpServlet, 并重写其 doPost 方法), 在其中获取请求的 user, password. 
	利用 JDBC 从 test_users 中查询有没有和页面输入的 user, password 对应的记录
	SELECT count(id) FROM test_users WHERE user = ? AND password = ?
	若有, 响应 Hello:xxx, 若没有, 响应 Sorry: xxx  xxx 为 user.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A04LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		获取请求参数：
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		PrintWriter out = resp.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/atllm";
			String user = "root";
			String password2 = "root";
			connection = DriverManager.getConnection(url,user,password2);
			
//			写SQL语句：
			String sql = "SELECT count(id) FROM users WHERE username = ? " +
					"AND password = ?";
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			resultSet = ps.executeQuery();
			
			if(resultSet.next()){
				int count = resultSet.getInt(1);
				if(count > 0 ){
					out.print("hello: " + username);
				}else{
					out.println("sorry: "+ username);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
