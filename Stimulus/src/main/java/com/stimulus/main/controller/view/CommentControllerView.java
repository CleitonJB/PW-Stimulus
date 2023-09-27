package com.stimulus.main.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stimulus.main.entities.Comment;
import com.stimulus.main.services.CommentService;

@Controller
@RequestMapping(path = "/form")
public class CommentControllerView {
	@Autowired
    private CommentService commentService;

	@GetMapping("/comments")
	public String listComments(Model model) {
		try {
			model.addAttribute("comments", commentService.findAll());
			return "listComments";
		} catch(Exception exception) {
			throw exception;
		}
	}

	@GetMapping("/comment/{id}/{mode}")
	public String formComment(@PathVariable("id") String id, @PathVariable("mode") String mode, Model model) throws Exception {
		try {
			switch(mode) {
				case "new":
					model.addAttribute("comment", new Comment());
					model.addAttribute("mode", "new");
				break;
				
				case "change":
					model.addAttribute("comment", commentService.findById(Long.parseLong(id)));
					model.addAttribute("mode", "change");
				break;
				
				case "delete":
					model.addAttribute("comment", commentService.findById(Long.parseLong(id)));
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