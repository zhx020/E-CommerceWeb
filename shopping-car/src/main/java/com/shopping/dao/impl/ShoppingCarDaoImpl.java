package com.shopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.base.dao.impl.BaseDaoImpl;
import com.shopping.dao.ShoppingCarDao;
import com.shopping.entity.ShoppingCar;
@Repository
public class ShoppingCarDaoImpl extends BaseDaoImpl<ShoppingCar> implements ShoppingCarDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ShoppingCar getByGoodsAndUser(Integer goodsId, Integer userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("from " + ShoppingCar.class.getSimpleName() + " where 1 = 1");
		List<Object> params = new ArrayList<>();
		if(goodsId != null) {
			sql.append(" and goodsId = ?");
			params.add(goodsId);
		}
		if(userId != null) {
			sql.append(" and userId = ?");
			params.add(userId);
		}
		List<ShoppingCar> queryList = queryList(sql.toString(), params);
		if(!CollectionUtils.isEmpty(queryList)) {
			return queryList.get(0);
		}
		return null;
	}

	@Override
	public List<ShoppingCar> queryShoppingCars(String sql, List<Integer> asList) {
		if(asList == null) {
			asList = new ArrayList<>();
		}
		return jdbcTemplate.query(sql, asList.toArray(), new BeanPropertyRowMapper<ShoppingCar>(ShoppingCar.class));
	}

}
