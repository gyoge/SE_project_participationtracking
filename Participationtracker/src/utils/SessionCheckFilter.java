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
import javax.servlet.http.HttpSession;

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
	    
	    if (req.getSession().getAttribute("LOGIN_USER") == null) { //checks if there's a LOGIN_USER set in session
	 	   req.getSession().setAttribute("ORIGIN_PAGE", req.getRequestURI().split("/")[req.getRequestURI().split("/").length-1]);
	        res.sendRedirect(contextPath + "/Login");
	    } else {
	      fc.doFilter(request, response);
	    }
	  }

	  @Override
	  public void destroy() {
	  }

}