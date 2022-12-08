package com.sema.kittinder.models;

import com.sema.kittinder.dtos.UserRegistrationDTO;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String username;
	private String password;
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;
	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Kitten> kittens;

	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private UserProfile userProfile;

	public User(UserRegistrationDTO userRegistrationDTO, PasswordEncoder passwordEncoder) {
		this.username = userRegistrationDTO.getUsername();
		this.password = passwordEncoder.encode(userRegistrationDTO.getPassword());
		this.accountNonLocked = true;
		this.email = userRegistrationDTO.getEmail();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "read");
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
