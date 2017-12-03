package com.tz.loginAndRegiterDemo.sysmanage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.loginAndRegiterDemo.sysmanage.dao.impl.RegisterDaoImpl;
import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

/*
 * 用户注册请求类
 */
@WebServlet("/register")
public class RegisterAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nikename = req.getParameter("nikename");
		String phoneNumber = req.getParameter("phoneNumber");
		User user = new User(username,password,nikename,phoneNumber);
		RegisterDaoImpl registerDao = new RegisterDaoImpl();
		boolean result = registerDao.userRegister(user);
		if(result){
			resp.sendRedirect("registersuccess.jsp");
		}else{
			resp.sendRedirect("error.jsp");
		}
	}

}
