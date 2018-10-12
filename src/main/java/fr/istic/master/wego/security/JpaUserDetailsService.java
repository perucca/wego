package fr.istic.master.wego.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.model.User;

@Component
public class JpaUserDetailsService implements UserDetailsService {

	private final UserDao repository;

	@Autowired
	public JpaUserDetailsService(UserDao repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.repository.findByEmail(email).get();
		return org.springframework.security.core.userdetails.User
				.withUsername(email)
				.password(user.getPassword())
				.authorities(AuthorityUtils.createAuthorityList("USER")).build();
				
	}

}