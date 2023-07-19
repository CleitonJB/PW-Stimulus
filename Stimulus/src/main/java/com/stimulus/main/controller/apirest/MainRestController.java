package com.stimulus.main.controller.apirest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stimulus.main.entities.User;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	//Formas de retornar dados para uma requisição
	
	//1
	//Retorna um dado simples
	@GetMapping
	public String initial() {
		return "Hello, buddy, welcome to my Spring project...this is my rest controller...";
	}
	
	//2
	//Retorna um parâmetro recebido pelo path da requisição
	@GetMapping("/user/{id}")
	public String page1(@PathVariable("id") int id) {
		return "O id fornecido foi: " + id;
	}
	
	//3
	//Retorna um parâmetro recebido pelo path e outro pelo params da requisição
	@GetMapping("/{id}")
	public String page2(@PathVariable("id") int id, @RequestParam("nome") String nome) {
		return "id: " + id + " - nome: " + nome;
	}
	
	//4
	//Retorna os vários (n) parâmetros recebidos pelo params da requisição
	@PostMapping("/foos")
	@ResponseBody
	public String page3(@RequestParam Map<String, String> allParams) {
		return "Parâmetros: " + allParams.entrySet();
	}
	
	//Validar campos enviados via body da requisição
	@PostMapping("/user/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> registerUser(@RequestBody Map<String, String> userMap) {
		try {
			if(userMap.get("id") == null) throw new Exception("O campo 'id' não foi informado!");
			if(userMap.get("username") == null) throw new Exception("O campo 'username' não foi informado!");
			if(userMap.get("password") == null) throw new Exception("O campo 'password' não foi informado!");

			System.out.println("ID: " + userMap.get("id"));
			System.out.println("Username: " + userMap.get("username"));
			System.out.println("Password: " + userMap.get("password"));
			
			return ResponseEntity.ok().body(userMap.toString());
		} catch (Exception err) {
			return ResponseEntity.badRequest().body("Erro ao registrar usuário: " + err);
		}
	}
	
	//VALENDO
//	@PostMapping(value = "/user/new")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<String> addUser(@RequestBody User userMap) {
//		try {
//			if(userMap.getId() == null) throw new Exception("O campo 'id' não foi informado!");
//			if(userMap.getUsername() == null) throw new Exception("O campo 'username' não foi informado!");
//			if(userMap.getEmail() == null) throw new Exception("O campo 'email' não foi informado!");
//
//			System.out.println("ID: " + userMap.getId());
//			System.out.println("Username: " + userMap.getUsername());
//			System.out.println("Email: " + userMap.getEmail());
//			
//			return ResponseEntity.ok().body(userMap.toString());
//		} catch (Exception err) {
//			return ResponseEntity.badRequest().body("Erro ao registrar usuário: " + err);
//		}
//	}
}