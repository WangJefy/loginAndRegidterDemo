package com.tz.loginAndRegiterDemo.sysmanage.action;

import javax.servlet.http.HttpServlet;
//ͨ���̳�HttpServlet�࣬ʵ����httpЭ�飬����ǰ�˺�����ݽ���
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.loginAndRegiterDemo.sysmanage.dao.impl.LoginDaoImpl;
import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//ͨ��@WebServlet("/login"),����action��login��ָ���ϵ��
//����һ�ַ�������web.xml���޸����ü���
//annotation��ע��

/**
 * ��������
 * LoginAction
 * �����ˣ�
 * ʱ�䣺2017�� 11��18��
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
		//req������� resp��Ӧ����
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
