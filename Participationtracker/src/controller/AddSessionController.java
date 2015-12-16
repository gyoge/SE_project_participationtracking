package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet("/Addsession")
public class AddSessionController extends HttpServlet {

	SessionFactory sf;
	private static final long serialVersionUID = 7585162767939336630L;
	
	public AddSessionController(){
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

	}
			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try{
			Memberinfo currentUser = (Memberinfo) request.getSession().getAttribute("LOGIN_USER");
			int courseid = Integer.parseInt(request.getParameter("courseid"));
			List<String> errorlist = new ArrayList<String>();
			
			if(currentUser!=null && currentUser.getRole().getId()>1){
				String dateStr = request.getParameter("date");
				int duration = Integer.parseInt(request.getParameter("duration"));
				String description = request.getParameter("description");

				Session session = sf.openSession();
				Query query = session.createQuery("FROM Course c WHERE id = :courseid");
				query.setParameter("courseid", courseid);
				Course course = (Course) query.list().get(0);
				
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = dateformat.parse(dateStr);
				model.Session newsession = new model.Session(date, duration, description, course);
				
				session.save(newsession);
				session.close();
			} else {
				errorlist.add("Access denied!");
			}
			
			request.setAttribute("errorlist", errorlist);
			request.getRequestDispatcher("/WEB-INF/view/viewcourse.jsp?courseid="+courseid).forward(request, response);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
