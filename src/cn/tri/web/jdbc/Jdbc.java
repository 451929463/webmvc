package cn.tri.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	
	public static void main(String[] args) throws Exception {
			//����jar����ע����������
			System.out.println("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			//��һ������
			String user = "root";
			String pwd = "admin";
			String url = "jdbc:mysql://localhost:3306/project";
			System.out.println("connetion DB");
			Connection conn = DriverManager.getConnection(url,user,pwd);
			//ִ��һ����ѯ
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from p_user");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id+"---"+name+"---"+age);
			}
	
		
	}
}
