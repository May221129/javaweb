package com.llm.a01base.a03thirdwebapp;
/**
	��ϰ�������ݿ���н���
	�� MySQL ���ݿ��д���һ�� test_users ���ݱ�, ��� 3 ���ֶ�: id, user, password. ��¼�뼸����¼. 
	����һ�� login.html, ��߶������������ֶ�: user, password. �������� loginServlet
	�ٴ���һ�� LoginServlet(��Ҫ�̳��� HttpServlet, ����д�� doPost ����), �����л�ȡ����� user, password. 
	���� JDBC �� test_users �в�ѯ��û�к�ҳ������� user, password ��Ӧ�ļ�¼
	SELECT count(id) FROM test_users WHERE user = ? AND password = ?
	����, ��Ӧ Hello:xxx, ��û��, ��Ӧ Sorry: xxx  xxx Ϊ user.
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
		
//		��ȡ���������
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
			
//			дSQL��䣺
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
