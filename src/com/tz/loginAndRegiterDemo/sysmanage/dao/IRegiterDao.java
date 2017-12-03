package com.tz.loginAndRegiterDemo.sysmanage.dao;

import com.tz.loginAndRegiterDemo.sysmanage.entity.User;

/*
 * 用户注册接口
 */
public interface IRegiterDao {
	boolean userRegister(User user);
}
