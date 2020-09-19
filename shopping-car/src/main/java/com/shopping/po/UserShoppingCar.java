package com.shopping.po;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.shopping.entity.ShoppingCar;

public class UserShoppingCar {
	private Integer userId;
	private List<ShoppingCar> list;
	private double totalPrice = 0.0;
	private int totalCount = 0;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<ShoppingCar> getList() {
		return list;
	}
	public void setList(List<ShoppingCar> list) {
		if(!CollectionUtils.isEmpty(list)) {
			for(ShoppingCar car : list) {
				this.totalPrice += car.getTotalPrices();
				this.totalCount += car.getNums();
			}
		}
		this.list = list;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public int getTotalCount() {
		return totalCount;
	}
}
