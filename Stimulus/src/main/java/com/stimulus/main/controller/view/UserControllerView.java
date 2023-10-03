package com.stimulus.main.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stimulus.main.entities.User;
import com.stimulus.main.services.UserService;

@Controller
@RequestMapping(path = "/form")
public class UserControllerView {

    @Autowired
    private UserService userService;

	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "listUsers";
	}

	@GetMapping("/user/{id}/{mode}")
	public String formUser(@PathVariable("id") String id, @PathVariable("mode") String mode, Model model) {
		switch(mode) {
			case "new":
				model.addAttribute("user", new User());
				model.addAttribute("mode", "new");
			break;
			
			case "change":
				model.addAttribute("user", userService.findById(Long.parseLong(id)));
				model.addAttribute("mode", "change");
			break;
			
			case "delete":
				model.addAttribute("user", userService.findById(Long.parseLong(id)));
				model.addAttribute("mode", "delete");
			break;
		}
		
		return "formUser";
	}
}