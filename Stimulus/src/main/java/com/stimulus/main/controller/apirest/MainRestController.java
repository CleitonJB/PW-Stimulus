package com.stimulus.main.controller.apirest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}