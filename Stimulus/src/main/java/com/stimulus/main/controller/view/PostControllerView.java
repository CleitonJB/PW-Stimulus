package com.stimulus.main.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stimulus.main.entities.Comment;
import com.stimulus.main.entities.Post;
import com.stimulus.main.services.PostService;

@Controller
@RequestMapping(path = "/form")
public class PostControllerView {
	@Autowired
    private PostService postService;

	/* POST */
	
	// Listar postagens
	@GetMapping("/posts")
	public String listPosts(Model model) {
		try {
			model.addAttribute("posts", postService.findAll());
			return "listPosts";
		} catch(Exception exception) {
			throw exception;
		}
	}

	// CRUD das postagens
	@GetMapping("/post/{id}/{mode}")
	public String formPost(@PathVariable("id") String id, @PathVariable("mode") String mode, Model model) throws Exception {
		try {
			switch(mode) {
				case "new":
					model.addAttribute("post", new Post());
					model.addAttribute("mode", "new");
				break;
				
				case "change":
					model.addAttribute("post", postService.findById(Long.parseLong(id)));
					model.addAttribute("mode", "change");
				break;
				
				case "delete":
					model.addAttribute("post", postService.findById(Long.parseLong(id)));
					model.addAttribute("mode", "delete");
				break;
				
				default:
					throw(new Exception("Modo de abertura de modal não identificado."));
			}
			
			return "formPost";
		} catch(Exception exception) {
			throw exception;
		}
	}
	
	/* COMMENT */
	
	@GetMapping("/post/{id}/comments")
	public String listComments(@PathVariable("id") String id, Model model) {
		try {
			model.addAttribute("comments", postService.findCommentsAll(Long.parseLong(id)));
			return "listComments";
		} catch(Exception exception) {
			throw exception;
		}
	}
	
	@GetMapping("/post/{id}/comment/{idComment}/{mode}")
	public String formComment(@PathVariable("id") String id, @PathVariable("idComment") String idComment, @PathVariable("mode") String mode, Model model) throws Exception {
		try {
			switch(mode) {
				case "new":
					model.addAttribute("comment", new Comment());
					model.addAttribute("mode", "new");
				break;
				
				case "change":
					//model.addAttribute("comment", postService.findCommentById(Long.parseLong(id)));
					model.addAttribute("mode", "change");
				break;
				
				case "delete":
					//model.addAttribute("comment", postService.findCommentById(Long.parseLong(id)));
					model.addAttribute("mode", "delete");
				break;
				
				default:
					throw(new Exception("Modo de abertura de modal não identificado."));
			}
			
			return "formComment";
		} catch(Exception exception) {
			throw exception;
		}
	}
}