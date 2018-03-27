package org.tysf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tysf.domain.User;

/**
 * Servlet Filter implementation class IsLogin
 */
@WebFilter("/hnnu")
public class IsLogin implements Filter {

    /**
     * Default constructor. 
     */
    public IsLogin() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse resp= (HttpServletResponse) response;
		User user=(User) req.getSession().getAttribute("loginUser");
		System.out.println(req.getContextPath()+"/jsp/login.jsp");
		if(user==null){
			resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
			
		}else{
			chain.doFilter(req, resp);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
