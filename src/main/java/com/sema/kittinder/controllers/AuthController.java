package com.sema.kittinder.controllers;

import com.sema.kittinder.dtos.UserRegistrationDTO;
import com.sema.kittinder.models.User;
import com.sema.kittinder.services.TokenService;
import com.sema.kittinder.services.UserDetailsServiceImpl;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class AuthController {
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	private final TokenService tokenService;
	private final UserDetailsServiceImpl userDetailsManager;
	private final PasswordEncoder passwordEncoder;

	public AuthController(TokenService tokenService, UserDetailsServiceImpl userDetailsManager,
						  PasswordEncoder passwordEncoder) {
		this.tokenService = tokenService;
		this.userDetailsManager = userDetailsManager;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/token")
	public String token(Authentication authentication) {
		LOG.debug("Token request for user: '{}'", authentication.getName());
		String token = tokenService.generateToken(authentication);
		LOG.debug("Token granted {}", token);
		return token;
	}

	@PostMapping(value = "/register")
	public void addUser(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO) {
		try {
			User user = new User(userRegistrationDTO, passwordEncoder);
			userDetailsManager.createUser(user);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid values");
		}
	}
}
