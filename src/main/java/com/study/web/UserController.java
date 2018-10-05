package com.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.domain.User;

@Controller
public class UserController {
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user) {
		System.out.println(user);
		return "welcome";
	}
}
