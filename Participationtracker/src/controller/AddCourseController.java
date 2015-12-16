package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.Memberinfo;
import model.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseController extends HttpServlet{
	SessionFactory sf;
	private static final long serialVersionUID = 1463593739017788349L;
	
	public AddCourseController(){
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
		String test = request.getRequestURI();
		request.getRequestDispatcher("/WEB-INF/view/addcourse.jsp").forward(request, response);
		
				
	}
			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try{
			Memberinfo currentUser = (Memberinfo) request.getSession().getAttribute("LOGIN_USER");
			List<String> errorlist = new ArrayList<String>();
			
			if(currentUser!=null && currentUser.getRole().getId()>1){
				String name = request.getParameter("name");
				String code = request.getParameter("code");
				String dateStr = request.getParameter("date");
				String description = request.getParameter("description");
				
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = dateformat.parse(dateStr);
				Course course = new Course(name, code, date, description, currentUser);
				
				Session session = sf.openSession();
				session.save(course);
				session.close();
				
				request.getRequestDispatcher("/WEB-INF/view/viewcourse.jsp?courseid="+course.getId()).forward(request, response);
			} else {
				errorlist.add("Access denied!");
			}
			
			request.setAttribute("errorlist", errorlist);
			request.getRequestDispatcher("/WEB-INF/view/listcourse.jsp?teacherid="+currentUser.getId()).forward(request, response);
		} catch(Exception e){
			
		}
	}
}
