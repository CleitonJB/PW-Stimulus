package com.stimulus.main.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stimulus.main.entities.Comment;
import com.stimulus.main.services.CommentService;

@RestController
@RequestMapping(path = "/api")
public class CommentRestController {
	@Autowired
	private CommentService commentService;

	@GetMapping(value = "/comments")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(commentService.findAll());
	}

	@GetMapping(value = "/comment/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(commentService.findById(id));
	}

	@PostMapping(value = "/comment")
	public ResponseEntity save(@RequestBody Comment comment) {
		commentService.save(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(comment);
	}

	@PutMapping(value = "/comment")
	public ResponseEntity update(@RequestBody Comment comment) {
		commentService.update(comment);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/comment/{id}", method=RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("id") Long id) {
		commentService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}