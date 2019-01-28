package cn.tri.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	
	public static void main(String[] args) throws Exception {
			//导入jar包，注册驱动程序
			System.out.println("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			//打开一个连接
			String user = "root";
			String pwd = "admin";
			String url = "jdbc:mysql://localhost:3306/project";
			System.out.println("connetion DB");
			Connection conn = DriverManager.getConnection(url,user,pwd);
			//执行一个查询
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
