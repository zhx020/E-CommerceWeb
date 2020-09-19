package com.shopping.service;

import com.project.base.po.DDModel;
import com.project.base.po.Page;
import com.project.base.po.Result;
import com.shopping.entity.User;

public interface UserService {
	Result<User> login(String userName,String password);

	Result<User> register(User user);
}
