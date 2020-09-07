package com.ecommerce.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ecommerce.shop.context.LoginContext;
import com.ecommerce.shop.user.Principal;

@Component
@Order(2)
public class AuthenticationFilter  implements Filter {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		    HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        LOG.info("Authentication");
	        String userId = req.getHeader("userId");
	        Principal principal = new Principal();
	        principal.setId(userId);
	       // LoginContext loginContext = new LoginContext();
	        LoginContext.setPrincipal(principal);
	        chain.doFilter(request, response);
	        //LOG.info("Logging Response :{}",  res.getContentType());
		
	}

}
