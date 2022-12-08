package com.sema.kittinder.services;

import com.sema.kittinder.dtos.UserProfileDTO;
import com.sema.kittinder.models.User;
import com.sema.kittinder.models.UserProfile;
import com.sema.kittinder.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	UserProfileRepository userProfileRepository;

	public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	@Override
	public UserProfile createUserProfile(User user) {
		UserProfile profile = new UserProfile();
		profile.setUser(user);
		userProfileRepository.save(profile);
		return profile;
	}

	@Override
	public void updateUserProfile(UserProfileDTO userProfileDTO, UserProfile userProfile) {
		userProfileDTO.getFirstName().ifPresent(userProfile::setFirstName);
		userProfileDTO.getLastName().ifPresent(userProfile::setLastName);
		userProfileDTO.getAddress().ifPresent(userProfile::setAddress);
		userProfileDTO.getPhoneNumber().ifPresent(userProfile::setPhoneNumber);
		userProfileDTO.getDescription().ifPresent(userProfile::setDescription);
		userProfileDTO.getProfilePictureURL().ifPresent(userProfile::setProfilePictureURL);
	}

	@Override
	public UserProfile findByUser(User user) {
		return userProfileRepository.findByUser(user);
	}
}
