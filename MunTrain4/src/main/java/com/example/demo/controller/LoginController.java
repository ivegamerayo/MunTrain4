package com.example.demo.controller;

import java.util.Optional;

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
public class LoginController {
	
	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public ModelAndView getAllUsers() {
		log.debug("request to get Login");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/login")
	public String saveUser(@ModelAttribute("user") User user) {
		log.debug("request to find User : {}", user);

		// Si el producto existe 
		Optional<User> existingUserWrap = userService.login(user.getLogin(), user.getPassword());
		if (existingUserWrap.isPresent()) {
			return "redirect:/menu";
		}else {
			return "redirect:/register";
		}
		
	}


}
