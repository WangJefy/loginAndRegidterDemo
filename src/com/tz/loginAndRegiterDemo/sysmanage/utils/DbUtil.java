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
 * 数据库工具类（连接数据库）
 */
public class DbUtil {
	//连接数据库四要素
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//加载配置文件
	static{
		loadResource();
	}
	/*
	 * 配置文件的方法
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
		//就可以去数据库查询数据了
		try {
			//动态加载数据库驱动
			Class.forName(driver);//将驱动地址放进来
			//连接对象
			connection = DriverManager.getConnection(url,username,password);
//			System.out.println(connection);
			String sql = "select id, username,password,nikename,phoneNumber,createDate,updateDate from user where username=? and password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();//产生结果集
			while(rs.next()){
				user2 = new User();
				user2.setUsername(rs.getString("username"));//rs.getString("username")是从数据库中取出的数据。
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
	
	
	//单元测试通过引入JUnit测试包实现
	@Test
	public void connectionTest() throws SQLException{
		User qu = queryUserOne(new User("admin","admin"));//若想测试成功，mysql中必须有以user为名的数据库。
		System.out.println(qu);
	}
}
