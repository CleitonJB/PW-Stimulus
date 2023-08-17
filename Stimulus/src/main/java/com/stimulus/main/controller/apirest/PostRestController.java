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

import com.stimulus.main.entities.Post;
import com.stimulus.main.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "Post", description = "Endpoints para o gerenciamento das Publicações (Post)")
public class PostRestController {
	@Autowired
	private PostService postService;

	@Operation(summary = "Obter uma lista das publicações", description = "Obter uma lista das publicações cadastradas", tags = { "Post" })
	@GetMapping(value = "/posts")
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok(postService.findAll());
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}

	@Operation(summary = "Obter uma publicação", description = "Obter uma publicação específica baseado no seu campo 'id'", tags = { "Post" })
	@GetMapping(value = "/post/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(postService.findById(id));
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}

	@Operation(summary = "Criar uma publicação", description = "Criar uma nova publicação (caso já não exista)", tags = { "Post" })
	@PostMapping(value = "/post")
	public ResponseEntity save(@RequestBody Post post) {
		try {
			if(post.getUser() == null) {
				return ResponseEntity.badRequest().body("O Usário não foi informado!");
			} else {
				postService.save(post);
				return ResponseEntity.status(HttpStatus.CREATED).body(post);
			}
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}

	@Operation(summary = "Atualizar os dados de uma publicação", description = "Atualizar os dados de uma publicação (enviar todos os campos)", tags = { "Post" })
	@PutMapping(value = "/post")
	public ResponseEntity update(@RequestBody Post post) {
		try {
			postService.update(post);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}

	@Operation(summary = "Excluir uma publicação", description = "Excluir uma publicação baseado no seu campo 'id'", tags = { "Post" })
	@DeleteMapping(value = "/post/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			postService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception error) {
			return ResponseEntity.status(500).body(error.getMessage());
		}
	}
}