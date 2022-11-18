package com.sema.kittinder.controllers;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController

public class MainRestController {

	@GetMapping
	public String home(Principal principal) {
		return "Hello " + principal.getName();
	}

}
