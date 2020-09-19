package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.base.po.Result;
import com.shopping.po.UserShoppingCar;
import com.shopping.service.ShoppingCarService;

@Controller
@RequestMapping("car")
public class ShoppoingCarController {
	private String preffix = "shopping";
	@Autowired
	private ShoppingCarService shoppingCarService;
	
	@RequestMapping("add")
	@ResponseBody
	public Result<String> add(int goodsId) {
		shoppingCarService.addCar(goodsId);
		return Result.success();
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Result<String> delete(Integer id,Integer count) {
		shoppingCarService.delete(id,count);
		return Result.success();
	}
	
	@RequestMapping("purchase")
	@ResponseBody
	public Result<String> purchase(Integer id) {
		shoppingCarService.purchase(id);
		return Result.success();
	}
	
	@RequestMapping("myCars")
	public String myCars(HttpServletRequest request) {
		UserShoppingCar car = shoppingCarService.myCars();
		request.setAttribute("car", car);
		return preffix + "/cars";
	}
}
