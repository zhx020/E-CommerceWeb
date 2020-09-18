package com.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.base.po.Result;
import com.project.base.util.MD5Util;
import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public Result<User> login(String userName, String password) {
		User user = userDao.getUserByUserName(userName);
		if(user == null) {
			throw new RuntimeException("user doesn't exist");
		}
		if(!MD5Util.md5(password).equals(user.getPassword())) {
			throw new RuntimeException("wrong password");
		}
		return Result.success(user,null);
	}

	@Override
	public Result<User> register(User user) {
		User existUser = userDao.getUserByUserName(user.getUserName());
		if(existUser != null) {
			throw new RuntimeException("user already exists");
		}
		user.setPassword(MD5Util.md5(user.getPassword()));
		userDao.saveUser(user);
		return Result.success(user, null);
	}

}
