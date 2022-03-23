package com.example.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.service.UserService;
import com.example.springboot.web.dto.UserRegistartionDto;

@Controller
@RequestMapping("/registration")
public class UserRegistartionController {
	
	@Autowired
	private UserService userService;

	public UserRegistartionController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public String showRegistartionForm(Model model) {
		model.addAttribute("user",new UserRegistartionDto());
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistartionDto registartionDto) {
		userService.save(registartionDto);
		return "redirect:/registration?success";
	}

}
