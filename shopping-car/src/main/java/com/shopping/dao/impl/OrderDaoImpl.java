package com.shopping.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.base.dao.impl.BaseDaoImpl;
import com.shopping.dao.OrderDao;
import com.shopping.entity.Order;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{

}
