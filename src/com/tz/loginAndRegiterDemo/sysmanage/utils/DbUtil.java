package com.tz.loginAndRegiterDemo.sysmanage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

/*
 * ���ݿ⹤���ࣨ�������ݿ⣩
 */
public class DbUtil {
	//�������ݿ���Ҫ��
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//���������ļ�
	static{
		loadResource();
	}
	/*
	 * �����ļ��ķ���
	 */
	public static void loadResource(){
		InputStream in = DbUtil.class.getResourceAsStream("/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public static User queryUserOne(User user) throws SQLException{
		User user2 = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�Ϳ���ȥ���ݿ��ѯ������
		try {
			//��̬�������ݿ�����
			Class.forName(driver);//��������ַ�Ž���
			//���Ӷ���
			connection = DriverManager.getConnection(url,username,password);
//			System.out.println(connection);
			String sql = "select id, username,password,nikename,phoneNumber,createDate,updateDate from user where username=? and password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();//���������
			while(rs.next()){
				user2 = new User();
				user2.setUsername(rs.getString("username"));//rs.getString("username")�Ǵ����ݿ���ȡ�������ݡ�
				user2.setPassword(rs.getString("password"));
				user2.setNikename(rs.getString("nikename"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
		}
		
		
		return user2;
	}
	
	public static int addUser(User user) throws SQLException{
		int rowNum = 0;
		
		Connection connection = null;
		PreparedStatement ps = null;
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
//			System.out.println(connection);
			String sql = "insert into user(username,password,nikename,phoneNumber) values(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNikename());
			ps.setString(4, user.getPhoneNumber());
			rowNum = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();		
		}finally{
			if(connection != null){
				connection.close();
			}
			
			if(ps != null){
				ps.close();
			}
		}
		return rowNum;
	}
	
	
	//��Ԫ����ͨ������JUnit���԰�ʵ��
	@Test
	public void connectionTest() throws SQLException{
		User qu = queryUserOne(new User("admin","admin"));//������Գɹ���mysql�б�������userΪ�������ݿ⡣
		System.out.println(qu);
	}
}
