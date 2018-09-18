package com.llm.a02mvc.a01mvcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao5 {
	
//	删除某个学生信息的方法：
	public void deleteByFlowId(Integer flowId){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE FROM examstudent WHERE flow_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, flowId);
//			完成前面的删除操作之后，需要更新：
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(preparedStatement != null){
					preparedStatement.close();
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
	
//	查询所有学生信息的方法：
	public List<Student4> getAll(){
		
		List<Student4> students = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT flow_id,type,id_card,exam_card,student_name,location,grade FROM examstudent";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int flowId = resultSet.getInt(1);
				int type = resultSet.getInt(2);
				String idCard = resultSet.getString(3);
				String examCard = resultSet.getString(4);
				String studentName = resultSet.getString(5);
				String location = resultSet.getString(6);
				int grade = resultSet.getInt(7);
				
				Student4 student4 = new Student4(flowId, type, idCard, examCard, studentName, location, grade);
				students.add(student4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(preparedStatement != null){
					preparedStatement.close();
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
		
		return students;
	}
}
