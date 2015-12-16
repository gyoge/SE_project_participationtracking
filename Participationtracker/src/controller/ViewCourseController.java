package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.Memberinfo;
import model.Role;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/Viewcourse")
public class ViewCourseController extends HttpServlet {
	SessionFactory sf;
	private static final long serialVersionUID = 1463593739017788349L;
	
	public ViewCourseController(){
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
		
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		
		Session session = sf.openSession();
		 
		Query query = session.createQuery("FROM Course c WHERE c.id= :courseid");
		query.setParameter("courseid", courseid);
		Course course = (Course) query.list().get(0);
		query = session.createQuery("FROM Session s WHERE s.course.id= :courseid");
		query.setParameter("courseid", courseid);
		List<model.Session> sessionlist = query.list();
		
		request.setAttribute("course", course);
		request.setAttribute("courseid", course.getId());
		request.setAttribute("sessionlist", sessionlist);
		request.setAttribute("role", ((Memberinfo)request.getSession().getAttribute("LOGIN_USER")).getRole().getId());

		request.getRequestDispatcher("/WEB-INF/view/viewcourse.jsp").forward(request, response);
		
		session.clear();
				
	}
			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	}
}
