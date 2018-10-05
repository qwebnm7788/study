package com.study.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.domain.User;

@Controller
public class UserController {
	private List<User> users = new ArrayList<>();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user) {
		System.out.println(user);
		users.add(user);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", users);
		return "list";
	}
}
