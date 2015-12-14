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

@WebServlet("/Listcourse")
public class ListCourseController extends HttpServlet{

	SessionFactory sf;
	private static final long serialVersionUID = 1463593739017788349L;
	
	public ListCourseController(){
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
		
		int teacherid=0;
		String teacheridStr = request.getParameter("teacherid");
		if(teacheridStr!=null && teacheridStr!=""){
			teacherid= Integer.parseInt(teacheridStr);
		}
		
		Session session = sf.openSession();
		 
		Query query = session.createQuery("FROM Course c WHERE c.teacher.id = :teacherid OR :teacherid=0");
		query.setParameter("teacherid", teacherid);
		List<Course> courses = query.list();
		
		request.setAttribute("courselist", courses);

		request.getRequestDispatcher("/WEB-INF/view/listcourse.jsp").forward(request, response);
		
		session.clear();
				
	}
			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	}

}
