package com.sema.kittinder.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import com.sema.kittinder.config.SecurityConfig;
import com.sema.kittinder.services.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest({HomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class HoneControllerTest {
	@Autowired
	MockMvc mvc;

	@Test
	void rootWhenUnauthenticatedThen401() throws Exception {
		this.mvc.perform(get("/"))
			.andExpect(status().isUnauthorized());
	}

	@Test
	void rootWhenAuthenticatedThenSaysHelloUser() throws Exception {
		MvcResult result = this.mvc.perform(post("/token")
				.with(httpBasic("dsebesta", "password")))
			.andExpect(status().isOk())
			.andReturn();

		String token = result.getResponse().getContentAsString();

		this.mvc.perform(get("/")
				.header("Authorization", "Bearer " + token))
			.andExpect(content().string("Hello, dsebesta"));
	}

	@Test
	@WithMockUser
	public void rootWithMockUserStatusIsOK() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().isOk());
	}

}