package learnjava.practice.spring.websecurity.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer(){
		System.out.println("bean created for SecurityWebApplicationInitializer");
	}
}
