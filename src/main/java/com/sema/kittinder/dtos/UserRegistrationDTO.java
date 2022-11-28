package com.sema.kittinder.dtos;

import com.sema.kittinder.customAnnotations.ValidEmail;
import com.sema.kittinder.customAnnotations.PasswordMatches;
import com.sema.kittinder.customAnnotations.ValidPassword;
import javax.validation.constraints.NotBlank;
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
	@NotBlank(message = "Username is mandatory!")
	private String username;
	@NotNull
	@NotEmpty
	@ValidPassword
	@NotBlank(message = "New password is mandatory!")
	private String password;
	@ValidPassword
	@NotBlank(message = "Password confirmation is mandatory!")
	private String password2;
	@NotNull
	@NotEmpty
	@ValidEmail
	@NotBlank(message = "Email is mandatory!")
	private String email;
}
