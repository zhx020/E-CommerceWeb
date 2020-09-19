package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.Order;
import com.shopping.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	private String preffix = "shopping";
	@Autowired
	private OrderService orderService;
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<Order> orders = orderService.queryOrders();
		request.setAttribute("orders", orders);
		return preffix + "/orders";
	}
}
