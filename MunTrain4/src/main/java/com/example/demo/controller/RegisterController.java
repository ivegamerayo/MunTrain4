package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class RegisterController {
	
	private final Logger log = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public ModelAndView getAllUsers() {
		log.debug("request to get Register");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") User user) {
		log.debug("request to save User : {}", user);

			User newUser = new User();
			newUser.setLogin(user.getLogin());
			newUser.setPassword(user.getPassword());
			newUser.setEmail(user.getEmail());
			
			userService.save(newUser);
			
			return "redirect:/menu";
	}

}
