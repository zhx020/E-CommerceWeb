package com.shopping.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.project.base.dao.impl.BaseDaoImpl;
import com.shopping.dao.UserDao;
import com.shopping.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	@Override
	public User getUserByUserName(String userName) {
		String hql = "from "+User.class.getSimpleName()+" where userName = ?";
		List<User> list = queryList(hql,Arrays.asList(userName));
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<User> getUsersByRoleAndSex(Integer roleCode, Integer sex) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("from " + User.class.getSimpleName() + " where 1 = 1 ");
		if(roleCode != null) {
			sql.append(" and roleCode = ?");
			params.add(roleCode);
		}
		if(sex != null && sex != -1) {
			sql.append(" and sex = ?");
			params.add(sex);
		}
		return queryList(sql.toString(), params);
	}

	@Override
	public void saveUser(User user) {
		save(user);
	}

}
