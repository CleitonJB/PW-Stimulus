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
		return ResponseEntity.ok(userService.findAll());
	}

	@Operation(summary = "Obter um usuário", description = "Obter um usuário específico baseado no seu campo 'id'", tags = { "User" })
	@GetMapping(value = "/user/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@Operation(summary = "Criar um usuário", description = "Criar um novo usuário (caso já não exista)", tags = { "User" })
	@PostMapping(value = "/user")
	public ResponseEntity save(@RequestBody User user) {
		userService.save(user, null);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@Operation(summary = "Atualizar os dados de um usuário", description = "Atualizar os dados de um usuário (enviar todos os campos)", tags = { "User" })
	@PutMapping(value = "/user")
	public ResponseEntity update(@RequestBody User user) {
		userService.update(user, null);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@Operation(summary = "Excluir um usuário", description = "Excluir um usuário baseado no seu campo 'id'", tags = { "User" })
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity <?> delete(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}