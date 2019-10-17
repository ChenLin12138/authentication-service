package com.chenlin.authentication.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author Chen Lin
 * @date 2019-10-17
 */

@Configuration
@EnableAuthorizationServer
public class JWTOAuth2Config extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;
	
    
    @Autowired
    private TokenStore tokenStore;
    
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    

    @Autowired
    private UserDetailsService userDetailsService;
    
    
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));
		
		endpoints.tokenStore(tokenStore)
		.accessTokenConverter(jwtAccessTokenConverter)
		.tokenEnhancer(tokenEnhancerChain)
		.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
	}


	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

      clients.inMemory()
              .withClient("organization")
              .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("organization666"))
              .authorizedGrantTypes("refresh_token", "password", "client_credentials")
              .scopes("webclient", "mobileclient");
  }
}
