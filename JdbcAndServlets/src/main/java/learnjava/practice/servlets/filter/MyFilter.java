package learnjava.practice.servlets.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("inside custom filter");
		PrintWriter out=response.getWriter();  
	    out.print("filter is invoked before");
	    chain.doFilter(request, response);
	    out.print("filter is invoked after");  	
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
