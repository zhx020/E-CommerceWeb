package com.shopping.dao;

import java.util.List;

import com.project.base.dao.BaseDao;
import com.shopping.entity.User;

public interface UserDao extends BaseDao<User>{

	User getUserByUserName(String userName);

	void saveUser(User user);

	List<User> getUsersByRoleAndSex(Integer roleCode, Integer sex);
}
