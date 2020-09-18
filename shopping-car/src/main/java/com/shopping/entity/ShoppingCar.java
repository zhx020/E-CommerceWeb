package com.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.project.base.constant.DBConst;

@Table(name=DBConst.SHOPPING_CAR)
@Entity
public class ShoppingCar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="user_id")
	private Integer userId;
	@Column(name="goods_id")
	private Integer goodsId;
	@Column(name="nums")
	private int nums = 1;
	@Transient
	private double totalPrices;
	@Transient
	private String name;
	@Transient
	private String image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public void addCount(int i) {
		this.nums += i;
	}
	public void subCount(Integer count) {
		this.nums -= count;
	}
	
}
