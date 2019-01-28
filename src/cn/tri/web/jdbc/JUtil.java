package cn.tri.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.tri.web.pojo.Student;

public class JUtil {
	private static String url = "" ;
	private static String user = "" ;
	private static String password = "" ;
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	//��������
	public Connection getConnection()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	//��ɾ�ģ�Ӱ��������
	public int getUpdate(String sql){
		int affectedline = 0;
		try {
			ps = conn.prepareStatement(sql);
			affectedline = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedline;
	}
	//��ѯ�����������
	public List<Student> getfind(String sql){
		Student stu = new Student();
		List<Student> list = null;
		try {
			conn.setAutoCommit(false);//��������
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setAge(rs.getString(3));
				list.add(stu);
			}
			conn.commit();//�ύ����
		} catch (SQLException e) {
			try {
				conn.rollback();//�ع�����
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return list;
	}
	//�ر����ݿ�����
	public void getClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
