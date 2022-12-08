package com.sema.kittinder.services;

import com.sema.kittinder.dtos.UserProfileDTO;
import com.sema.kittinder.models.User;
import com.sema.kittinder.models.UserProfile;

public interface UserProfileService {
	UserProfile createUserProfile(User user);

	void updateUserProfile(UserProfileDTO userProfileDTO, UserProfile userProfile);

	UserProfile findByUser(User user);
}
