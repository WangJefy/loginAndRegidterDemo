package com.tz.loginAndRegiterDemo.sysmanage.dao;
/*
 * �ӿ��������û���¼Dao��ӿ�
 */

import java.sql.SQLException;

import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

public interface ILoginDao {
	//��¼����
	public abstract boolean userLogin(User user) throws SQLException;
}
