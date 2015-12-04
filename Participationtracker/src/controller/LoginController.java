package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Memberinfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/Login")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static SessionFactory sf;
	private static final long serialVersionUID = -4015599647677928668L;
	
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Memberinfo.class);
		cfg.configure("/resources/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		List<Memberinfo> list = session.createCriteria(Memberinfo.class).list();
		respons
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
	}
		 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
}
