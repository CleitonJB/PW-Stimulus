package com.stimulus.main.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class MainControllerView {
	@GetMapping("")
	public String initialTemplate() {
		return "template";
	}
}