package com.study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.domain.User;
import com.study.persistence.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(User user) {
		System.out.println(user);
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "/user/form";
	}
	
	@RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.getOne(id));
		return "/user/updateForm";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, User newUser) {
		User user = userRepository.getOne(id);
		user.update(newUser);
		userRepository.save(user);
		return "redirect:/users";
	}
}
