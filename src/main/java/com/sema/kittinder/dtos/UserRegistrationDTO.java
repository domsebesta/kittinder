package com.sema.kittinder.dtos;

import com.sema.kittinder.customAnnotations.ValidEmail;
import com.sema.kittinder.customAnnotations.PasswordMatches;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class UserRegistrationDTO {
	@NotNull
	@NotEmpty
	private String username;
	@NotNull
	@NotEmpty
	private String password;
	private String password2;
	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;
}
