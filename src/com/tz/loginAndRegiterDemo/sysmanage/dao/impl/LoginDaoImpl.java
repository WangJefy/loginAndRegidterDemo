package com.tz.loginAndRegiterDemo.sysmanage.dao.impl;

import java.sql.SQLException;

import com.tz.loginAndRegiterDemo.sysmanage.dao.ILoginDao;
import com.tz.loginAndRegiterDemo.sysmanage.entity.User;
import com.tz.loginAndRegiterDemo.sysmanage.utils.DbUtil;

public class LoginDaoImpl implements ILoginDao{

	@Override
	public boolean userLogin(User user) throws SQLException {
		// TODO Auto-generated method stub
		//���ݿ�ȡ���ݣ�ȡ�������ٽ���ƥ��
		boolean flag = false;
		User queryUserOne = DbUtil.queryUserOne(user);
		if(queryUserOne != null){
			flag = true;
		}
		return flag;
	}

}
