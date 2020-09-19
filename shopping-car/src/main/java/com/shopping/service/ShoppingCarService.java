package com.shopping.service;

import com.shopping.po.UserShoppingCar;

public interface ShoppingCarService {

	void addCar(Integer goodsId);

	UserShoppingCar myCars();

	void delete(Integer id, Integer count);

	void purchase(Integer id);

}
