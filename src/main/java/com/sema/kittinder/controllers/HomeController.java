package com.sema.kittinder.controllers;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/")
	public String home(Principal principal) {
		return "Hello, " + principal.getName();
	}

}
