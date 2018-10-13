package fr.istic.master.wego.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import fr.istic.master.wego.model.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(User.PASSWORD_ENCODER);
	}

	@Override
	/**
	 * Autoriser les requêtes sur les objets statics du site et la page de login.
	 * Tout le reste des accès doit être authentifié
	 */
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().httpBasic().authenticationEntryPoint(authEntryPoint).and().authorizeRequests()
				.antMatchers("/", "/signin", "/logout").permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
	}
}
