package com.shopping.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.base.filter.SessionFilter;
import com.shopping.dao.OrderDao;
import com.shopping.entity.Order;
import com.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Order> queryOrders() {
		StringBuilder sql = new StringBuilder();
		Integer userId = SessionFilter.getUserId();
		sql.append("from " + Order.class.getSimpleName() + " where userId = ? order by fdate");
		return orderDao.queryList(sql.toString(),Arrays.asList(userId));
	}

}
