package com.chenlin.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * @author Chen Lin
 * @date 2019-09-30
 */

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	//覆盖configure()方法，定义了哪些客户端将注册到服务
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("eagleeye")
		.secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("thisissecret"))
		.authorizedGrantTypes("refersh_token","password","client_credentials")
		.scopes("webclient","mobileclient");
	}
	
	@Override
	//验证服务器的策略
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
	}

}
