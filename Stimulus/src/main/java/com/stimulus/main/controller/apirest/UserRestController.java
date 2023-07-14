package com.stimulus.main.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stimulus.main.entities.User;
import com.stimulus.main.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/user")
public class UserRestController {
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/new")
	public String addUser(User user) throws Exception {
		System.out.println("USER: " + user);
		User u = userRepo.save(user);
		return "Usuário adicionado: " + u.getId();
	}
}