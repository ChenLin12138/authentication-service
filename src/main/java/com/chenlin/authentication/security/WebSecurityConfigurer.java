package com.chenlin.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * @author Chen Lin
 * @date 2019-09-30
 */

//扩展核心的Spring Security的WebSecurityConfigurerAdapter
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception{
		return super.userDetailsServiceBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("chenlin")
		.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password1"))
		.roles("USERS")
		.and()
		.withUser("zdm")
		.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password2"))
		.roles("USERS","ADMIN");
	}
}
