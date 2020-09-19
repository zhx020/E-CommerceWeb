package com.shopping.service;

import java.util.List;

import com.shopping.entity.Goods;

public interface GoodsService {

	void addGoods(Goods goods);

	List<Goods> listGoods(String name);

	Goods getGoods(Integer goodsId);

}
