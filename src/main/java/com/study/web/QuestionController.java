package com.study.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.domain.Question;
import com.study.domain.User;
import com.study.persistence.QuestionRepository;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(value = "/form",  method = RequestMethod.GET)
	public String form(HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		return "/qna/form";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(String title, String contents, HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		
		User sessionedUser = HttpSessionUtils.getUserFromSession(session);
		Question newQuestion = new Question(sessionedUser.getUserId(), title, contents);
		questionRepository.save(newQuestion);
		return "redirect:/";
	}
}
