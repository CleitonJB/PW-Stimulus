package com.stimulus.main.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stimulus.main.entities.Post;
import com.stimulus.main.services.PostService;

@Controller
@RequestMapping(path = "/form")
public class PostControllerView {
	@Autowired
    private PostService postService;

	@GetMapping("/posts")
	public String listPosts(Model model) {
		model.addAttribute("posts", postService.findAll());
		return "listPosts";
	}

	@GetMapping("/post/{id}/{mode}")
	public String formPost(@PathVariable("id") String id, @PathVariable("mode") String mode, Model model) {
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
		}
		
		return "formPost";
	}
}