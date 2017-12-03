package com.tz.loginAndRegiterDemo.sysmanage.dao;
/*
 * 接口描述：用户登录Dao层接口
 */

import java.sql.SQLException;

import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

public interface ILoginDao {
	//登录方法
	public abstract boolean userLogin(User user) throws SQLException;
}
