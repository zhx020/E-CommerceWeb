package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.GoodsDao;
import com.shopping.entity.Goods;
import com.shopping.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodDao;
	@Override
	public void addGoods(Goods goods) {
		goodDao.save(goods);
	}
	@Override
	public List<Goods> listGoods(String name) {
		String hql = "from " + Goods.class.getSimpleName() + " where leftCount > 0";
		List<Object> params = new ArrayList<>();
		if(StringUtils.isNoneBlank(name)) {
			hql += " and name = ?";
			params.add(name);
		}
		return goodDao.queryList(hql, params);
	}
	@Override
	public Goods getGoods(Integer goodsId) {
		return goodDao.get(Goods.class, goodsId);
	}

}
