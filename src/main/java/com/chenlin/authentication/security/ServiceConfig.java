package com.chenlin.authentication.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Chen Lin
 * @date 2019-10-17
 */

@Component
public class ServiceConfig {
	
	  @Value("345345fsdgsf5345")
	  private String jwtSigningKey="";


	  public String getJwtSigningKey() {
	    return jwtSigningKey;
	  }
}
