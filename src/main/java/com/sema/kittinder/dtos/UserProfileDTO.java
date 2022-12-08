package com.sema.kittinder.dtos;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {
	Optional<String> firstName;
	Optional<String> lastName;
	Optional<String> address;
	Optional<String> phoneNumber;
	Optional<String> description;
	Optional<String> profilePictureURL;
}
