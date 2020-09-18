package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.base.po.Result;
import com.shopping.entity.User;
import com.shopping.service.UserService;

@Controller
@CrossOrigin
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request,String userName,String password) {
		Result<User> login = userService.login(userName, password);
		request.getSession().setAttribute("user", login.getData().getId());
		return "redirect:/goods/list";
	}
	@RequestMapping("register")
	public String register(User user,@RequestParam String password2) {
		if(!password2.equals(user.getPassword())) {
			throw new RuntimeException("2 passwords enterd are different");
		}
		userService.register(user);
		return "redirect:/goods/list";
	}
}
