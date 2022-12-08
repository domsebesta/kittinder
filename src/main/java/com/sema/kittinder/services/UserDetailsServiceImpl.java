package com.sema.kittinder.services;

import com.sema.kittinder.models.User;
import com.sema.kittinder.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {
		return userRepository.findUserByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("User not present"));
	}

	public void createUser(UserDetails user) {
		userRepository.save((User) user);
	}
}
