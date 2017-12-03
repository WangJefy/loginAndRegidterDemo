package com.tz.loginAndRegiterDemo.sysmanage.dao.impl;

import java.sql.SQLException;

import com.tz.loginAndRegiterDemo.sysmanage.dao.IRegiterDao;
import com.tz.loginAndRegiterDemo.sysmanage.entity.User;
import com.tz.loginAndRegiterDemo.sysmanage.utils.DbUtil;

public class RegisterDaoImpl implements IRegiterDao{

	@Override
	public boolean userRegister(User user) {
		//зЂВс
		boolean flag = false;
		int result;
		
		try {
			result = DbUtil.addUser(user);
			if(result>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
