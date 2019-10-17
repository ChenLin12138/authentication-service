package com.chenlin.authentication.utils;

import org.springframework.util.Assert;

/**
 * @author Chen Lin
 * @date 2019-09-08
 */

public class UserContextHolder {
	
	private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();
	
	public static final UserContext getContext() {
		UserContext context = userContext.get();
		
		if(context == null) {
			context = createEmptyContext();
			userContext.set(context);
		}
		return userContext.get();
	}

	public static final UserContext createEmptyContext() {
		// TODO Auto-generated method stub
		return new UserContext();
	}
	
	public static final void setContext(UserContext context) {
		Assert.notNull(context, "Only non-null UserContext instances are permitted");
		userContext.set(context);
	}
	
	
}
