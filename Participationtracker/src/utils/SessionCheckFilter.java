package utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Memberinfo;

public class SessionCheckFilter implements Filter {

	  private String contextPath;

	  @Override
	  public void init(FilterConfig fc) throws ServletException {
	    contextPath = fc.getServletContext().getContextPath();
	  }

	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    
	    String path = req.getRequestURL().toString();

	    if (req.getSession().getAttribute("LOGIN_USER") == null) { //checks if there's a LOGIN_USER set in session...
	        res.sendRedirect(contextPath + "/Login"); //or page where you want to redirect
	    } else {
	      Memberinfo user = (Memberinfo) req.getSession().getAttribute("LOGIN_USER");
	      fc.doFilter(request, response);
	      //res.sendRedirect(path);
	    }
	  }

	  @Override
	  public void destroy() {
	  }

}