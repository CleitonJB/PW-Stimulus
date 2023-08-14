package com.stimulus.main.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stimulus.main.entities.User;
import com.stimulus.main.services.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserRestController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@PostMapping(value = "/user")
	public ResponseEntity save(@RequestBody User user) {
		userService.save(user, null);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@PutMapping(value = "/user")
	public ResponseEntity update(@RequestBody User user) {
		userService.update(user, null);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}