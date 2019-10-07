package learnjava.practice.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@WebFilter("/hello")
@Component
@Order(1)
public class LogFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Hello from filter");
		chain.doFilter(request, response);
	}
	
	
	

}
