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

import com.stimulus.main.entities.Post;
import com.stimulus.main.services.PostService;

@RestController
@RequestMapping(path = "/api")
public class PostRestController {
	@Autowired
	private PostService postService;

	@GetMapping(value = "/posts")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(postService.findAll());
	}

	@GetMapping(value = "/post/{id}")
	public ResponseEntity getOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(postService.findById(id));
	}

	@PostMapping(value = "/post")
	public ResponseEntity save(@RequestBody Post post) {
		postService.save(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}

	@PutMapping(value = "/post")
	public ResponseEntity update(@RequestBody Post post) {
		postService.update(post);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/post/{id}", method=RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("id") Long id) {
		postService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}