package com.stimulus.main.controller.view;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/home")
public class MainControllerView {
	//Formas de retornar uma página HTML via path pesquisado
	
	//1
//	@GetMapping("/")
//	public String page1() {
//		return "index";
//	}
	
	//2
	@GetMapping("/something")
	@ResponseBody // Converte a página para texto simples
	public String page2() {
		return "index";
	}
	
	//3
	@GetMapping("/somethingg")
	public ResponseEntity<String> page3() {
		String body = "Hello world!"; //Conteúdo a ser retornado
		String etag = "uuuuepaaa! uuuuuuuuiiii"; //Espécie de tag para a página retornada
		return ResponseEntity.ok().eTag(etag).body(body);
	}
	
	//VALENDO
	@GetMapping("")
	public String initialTemplate() {
		return "template";
	}
}