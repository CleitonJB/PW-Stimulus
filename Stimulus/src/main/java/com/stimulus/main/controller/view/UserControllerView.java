package com.stimulus.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stimulus.main.entities.User;

@Controller
@RequestMapping(path = "/user")
public class UserControllerView {
	@GetMapping("/form/new")
	public String addUser() {
		return "addUser";
	}
	
	@PostMapping("/form/new2")
	public void addUser2(@RequestBody User user) {
		System.out.println("USER 2: " + user);
	}
	
//	@PostMapping("/form/new3")
//	public void addUser3(@ModelAttribute User user) {
//		System.out.println("USER 3: " + user);
//	}
}