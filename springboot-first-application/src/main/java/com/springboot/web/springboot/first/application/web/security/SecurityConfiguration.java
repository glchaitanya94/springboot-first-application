package com.springboot.web.springboot.first.application.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Create User - in28Minutes/dummy
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("chaitanya").password("chaitanya").roles("USER", "ADMIN");*/
		auth.inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
    		.withUser("chaitanya").password("chaitanya");
	}

	/*
	 * The below method is to override configure method
	 * for /login permit any body
	 * for matches or root page if he has a role of user
	 * if no user role shoe login page
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
			.antMatchers("/", "/*todo*/**")
				.access("hasRole('USER')").and().formLogin();
	}
}