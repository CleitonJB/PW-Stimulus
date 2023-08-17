package com.stimulus.main.controller.view;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Controller
@RequestMapping()
public class MainControllerView {
	@GetMapping("")
	public String initialTemplate() {
		return "template";
	}
	
	@Bean
	OpenAPI myOpenAPI() {
	    Contact contact = new Contact();
	    contact.setEmail("1kevinson.online@gmail.com");
	    contact.setName("Kevin KOUOMEU");
	    contact.setUrl("<https://hooo-api.com>");

	    Server localServer = new Server();
	    localServer.setUrl("http://localhost:8080");
	    localServer.setDescription("Server URL for Local development");

	    Server productionServer = new Server();
	    productionServer.setUrl("<https://hooo-api.com>");
	    productionServer.setDescription("Server URL in Production");

	    License mitLicense = new License()
	    .name("MIT License")
	    .url("<https://choosealicense.com/licenses/mit/>");

	    Info info = new Info()
	    .title("API de gerencimento de User, Post e Comment")
	    .contact(contact)
	    .version("1.0")
	    .description("Esta API disponibiliza endpoints para o gerencimento de User, Post e Comment.")
	    .license(mitLicense);

	    return new OpenAPI()
	        .info(info)
	        .servers(List.of(localServer, productionServer));
	}
}