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

import com.stimulus.main.entities.Comment;
import com.stimulus.main.services.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api")
@Tag(name = "Comment", description = "Endpoints para o gerenciamento dos Comentários (Comment)")
public class CommentRestController {
	@Autowired
	private CommentService commentService;

	@Operation(summary = "Obter uma lista de comentários", description = "Obter uma lista dos comentários cadastrados", tags = { "Comment" })
	@GetMapping(value = "/comments")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(commentService.findAll());
	}

	@Operation(summary = "Obter um comentário", description = "Obter um comentário específico baseado no seu campo 'id'", tags = { "Comment" })
	@GetMapping(value = "/comment/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(commentService.findById(id));
	}

	@Operation(summary = "Criar um comentário", description = "Criar um novo comentário (caso já não exista)", tags = { "Comment" })
	@PostMapping(value = "/comment")
	public ResponseEntity save(@RequestBody Comment comment) {
		commentService.save(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(comment);
	}

	@Operation(summary = "Atualizar os dados de um comentário", description = "Atualizar os dados de um comentário (enviar todos os campos)", tags = { "Comment" })
	@PutMapping(value = "/comment")
	public ResponseEntity update(@RequestBody Comment comment) {
		commentService.update(comment);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Operation(summary = "Excluir um comentário", description = "Excluir um comentário baseado no seu campo 'id'", tags = { "Comment" })
	@DeleteMapping(value = "/comment/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		commentService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}