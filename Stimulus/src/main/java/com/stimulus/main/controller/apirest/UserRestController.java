package com.stimulus.main.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stimulus.main.entities.User;
import com.stimulus.main.services.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/new")//, consumes={"application/x-www-form-urlencoded"}
	public String addUser(@RequestBody User user) {
		System.out.println("USER 11: " + user);
//		User u = userService.save(user, null);
		userService.save(user, null);
		return "Usuário cadastrado com sucesso: " + user.getId(); // model.toString()
	}
	
	@PostMapping(value = "/new2")//, consumes={"application/x-www-form-urlencoded"}
	public String addUser2(@ModelAttribute User user) {
		System.out.println("USER 22: " + user);
//		User u = userService.save(user, null);
		userService.save(user, null);
		return "Usuário cadastrado com sucesso: " + user.getId(); // model.toString()
	}
}