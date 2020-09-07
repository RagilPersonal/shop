package com.ecommerce.shop.context;

import com.ecommerce.shop.user.Principal;

public class LoginContext {

	private static ThreadLocal<Principal> threadLocal = new ThreadLocal<Principal>();
	
	private LoginContext() {
		
	}
	
	public static void setPrincipal(Principal principal) {
		threadLocal.set(principal);
	}
	
	public static Principal getPrincipal() {
		return threadLocal.get();
	}
	
	public static void remove() {
		threadLocal.remove();
	}
}
