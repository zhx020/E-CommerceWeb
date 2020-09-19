package com.shopping.dao;

import java.util.List;

import com.project.base.dao.BaseDao;
import com.shopping.entity.ShoppingCar;

public interface ShoppingCarDao extends BaseDao<ShoppingCar>{

	ShoppingCar getByGoodsAndUser(Integer goodsId, Integer userId);

	List<ShoppingCar> queryShoppingCars(String string, List<Integer> asList);

}
