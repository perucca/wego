package fr.istic.master.wego.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user")
		.password(passwordEncoder().encode("password")).roles("USER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
        .and()
        	.authorizeRequests()
		        //Autoriser les requêtes sur les objets statics du site et la page de login.
		        .antMatchers("/index.html","/static/*", "/", "/api/authenticate", "/api/subscribe").permitAll()
		        //Tout le reste des accès doit être authentifié
		        .anyRequest().authenticated();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
   
}
