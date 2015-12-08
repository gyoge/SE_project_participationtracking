package controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Memberinfo;
import model.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@WebServlet("/Register")
public class RegisterController extends HttpServlet {

	private static SessionFactory sf;
	private static final long serialVersionUID = 7804524886360637172L;
	
	public RegisterController(){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Memberinfo.class);
		cfg.addAnnotatedClass(Role.class);
		cfg.configure("/resources/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
				
	}
			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uuid = request.getParameter("uuid");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password_again = request.getParameter("password_again");
		String error = Memberinfo.validateEmail(email);
		if(error!=""){
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		}
		error = Memberinfo.validatePassword(password, password_again);
		if(error!=""){
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		}
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phonenum = request.getParameter("phonenum");

		Session session = sf.openSession();
		Role role = (Role) session.createQuery("from Role where id=1").list().get(0);
		Memberinfo newmember = null;
		try {
			newmember = new Memberinfo(uuid,email,password,name,address,phonenum,role);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		session.save(newmember);
		
		session.clear();
		session.disconnect();
		session.close();
		
		response.sendRedirect("/WEB-INF/view/login.jsp");
	}
}
