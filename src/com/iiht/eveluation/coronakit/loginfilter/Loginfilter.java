package com.iiht.eveluation.coronakit.loginfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Loginfilter
 */
@WebFilter("/adminlogin")
public class Loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String view ="";
		
		String username=request.getParameter("loginid"); 
		String password=request.getParameter("password");  
	    if(username.equals("admin") && password.equals("admin")){  
	    chain.doFilter(request, response);
	    
	    }  
	    else{  
	    view="errorpage.jsp";
	    RequestDispatcher rd=request.getRequestDispatcher(view);  
	    rd.include(request, response);  
	    }  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
