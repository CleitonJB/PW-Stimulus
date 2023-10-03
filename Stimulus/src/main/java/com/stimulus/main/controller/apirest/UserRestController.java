package com.stimulus.main.controller.apirest;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.stimulus.main.entities.User;
import com.stimulus.main.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "User", description = "Endpoints para o gerenciamento do Usuário (User)")
public class UserRestController {
	@Autowired
	private UserService userService;

	@Operation(summary = "Obter uma lista de usuários", description = "Obter uma lista dos usuários cadastrados", tags = { "User" })
	@GetMapping(value = "/users")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok(userService.findAll());
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}

	@Operation(summary = "Obter um usuário", description = "Obter um usuário específico baseado no seu campo 'id'", tags = { "User" })
	@GetMapping(value = "/user/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(userService.findById(id));
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}

	@Operation(summary = "Criar um usuário", description = "Criar um novo usuário (caso já não exista)", tags = { "User" })
	@PostMapping(value = "/user")
	public ResponseEntity save(@RequestBody User user) {
		try {
			userService.save(user, null);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);

//			Optional<User> result = userService.findById(user.getId());
//			
//			if(result.isEmpty()) {
//				userService.save(user, null);
//				return ResponseEntity.status(HttpStatus.CREATED).body(user);
//			} else {
//				return ResponseEntity.badRequest().body("O Usuário já está cadastrado!");
//			}
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}
	
	@Operation(summary = "Atualizar os dados de um usuário", description = "Atualizar os dados de um usuário (enviar todos os campos)", tags = { "User" })
	@PutMapping(value = "/user")
	public ResponseEntity update(@RequestBody User user) {
		try {
			Optional<User> result = userService.findById(user.getId());
			
			if(result.isEmpty()) {
				return ResponseEntity.badRequest().body("O Usuário não existe para ser atualizado!");
			} else {;
				userService.update(user, null);
				return ResponseEntity.status(HttpStatus.OK).build();
			}
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}
	
	@Operation(summary = "Excluir um usuário", description = "Excluir um usuário baseado no seu campo 'id'", tags = { "User" })
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity <?> delete(@PathVariable("id") Long id) {
		try {
			Optional<User> result = userService.findById(id);
			
			if(result.isEmpty()) {
				return ResponseEntity.badRequest().body("O Usuário não existe para ser excluído!");
			} else {
				userService.deleteById(id);
				return ResponseEntity.ok().build();
			}
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}
}