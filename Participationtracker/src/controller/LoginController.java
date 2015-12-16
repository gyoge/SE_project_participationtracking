package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.Memberinfo;
import model.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/Login")
public class LoginController extends HttpServlet{

	private static SessionFactory sf;
	private static final long serialVersionUID = -4015599647677928668L;
	
	public LoginController(){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(model.Session.class);
		cfg.addAnnotatedClass(Course.class);
		cfg.addAnnotatedClass(Memberinfo.class);
		cfg.addAnnotatedClass(Role.class);
		cfg.configure("/resources/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}  
		 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<String> errorlist = new ArrayList<String>();
		String target = "/WEB-INF/view/login.jsp";
		Memberinfo user = Memberinfo.getMemberinfo(request.getParameter("userid"));
		String password = request.getParameter("password");
		
		if(user!=null && Memberinfo.login(user, password)==""){
			HttpSession session = request.getSession();
			String originpage = (String) session.getAttribute("ORIGIN_PAGE");
            session.setAttribute("LOGIN_USER", user);
            session.setMaxInactiveInterval(30*60);
            
            if(originpage==null || originpage.equals("")){
            	target = "Listcourse";
            }else{
            	target = originpage;
            }
		} else {
			errorlist.add("Userid not found or password does not match!");
		}
		
		if(errorlist.size()>0){
			request.setAttribute("errorlist",errorlist);
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} else {
			response.sendRedirect(target);
		}
	}
}
