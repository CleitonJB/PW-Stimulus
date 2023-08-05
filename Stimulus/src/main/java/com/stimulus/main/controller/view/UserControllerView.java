package com.stimulus.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/form")
public class UserControllerView {
	@GetMapping("/users")
	public String listUsers() {
		return "listUsers";
	}
	
	@GetMapping("/user")
	public String formUser() {
		return "formUser";
	}
}