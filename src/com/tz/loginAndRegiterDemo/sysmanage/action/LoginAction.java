package com.tz.loginAndRegiterDemo.sysmanage.action;

import javax.servlet.http.HttpServlet;
//通过继承HttpServlet类，实现了http协议，建立前端后端数据交互
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.loginAndRegiterDemo.sysmanage.dao.impl.LoginDaoImpl;
import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//通过@WebServlet("/login"),建立action中login的指向关系。
//还有一种方法是在web.xml中修改配置即可
//annotation是注解

/**
 * 类描述：
 * LoginAction
 * 创建人：
 * 时间：2017年 11月18日
 * @author xzx
 *
 */
@WebServlet("/login")
public class LoginAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req请求对象； resp响应对象
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User(username,password);
		LoginDaoImpl daoImpl = new LoginDaoImpl();
		try {
			boolean result = daoImpl.userLogin(user);
			if(result){
				resp.sendRedirect("success.jsp");
			}else{
				resp.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
