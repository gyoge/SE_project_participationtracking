package model;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utils.PasswordHandler;

@Entity
@Table(name = "memberinfo")
public class Memberinfo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	protected int id;
	
	@Column(name = "userid", nullable = false)
	protected String userid;

	@Column(name = "email", nullable = false)
	protected String email;
	   
	@Column(name = "password", nullable = false)
	protected String password;
	   
	@Column(name = "salt", nullable = false)
	protected byte[] salt;
	   
	@Column(name = "name", nullable = false)
	protected String name;
	   
	@Column(name = "address")
	protected String address;
	   
	@Column(name = "phonenum")
	protected String phonenum;
	   
	@ManyToOne(targetEntity=Role.class)
	@JoinColumn(name="role_id")
	protected Role role;
	
	@OneToMany(mappedBy="teacher")
	protected Set<Course> taughtCourses;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="members")
	protected Set<model.Session> sessions;

	public int getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Set<model.Session> getSessions(){
		return this.sessions;
	}
	
	public static List<Memberinfo> getMemberinfos(){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Course.class);
		cfg.addAnnotatedClass(model.Session.class);
		cfg.addAnnotatedClass(Memberinfo.class);
		cfg.addAnnotatedClass(Role.class);
		cfg.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		List<Memberinfo> members = session.createQuery("FROM Memberinfo").list();
		if(members!=null && members.size()>0){
			return members;
		}
		return null;
	}
	
	public static Memberinfo getMemberinfo(String userid){
		List<Memberinfo> members = getMemberinfos();
		if(members!=null && members.size()>0){
			for(Memberinfo user : members){
				if(user.userid.equals(userid)){
					return user;
				}
			}
		}
		return null;
	}
	
	public static String login(Memberinfo user, String password){
		if(!user.password.equals(password)){
			return "The password do not match!";
		}
		return "";
	}
	
	public static String validateEmail(String email){
		int atcount = 0;
		for( int i=0; i<email.length(); i++ ) {
		    if( email.charAt(i) == '@' ) {
		        atcount++;
		        if(atcount>1){
		        	return "Too many @ found in email address!";
		        }
		    } 
		}
		int atpos = email.indexOf('@');
		if(atpos<1){
			return "No '@' was found or it is the first character!";
		}
		int dotpos = email.indexOf('.');
		if(dotpos<1 || dotpos<atpos || dotpos-1==atpos || dotpos==email.length()-1){
			return "No '.' was found, or it is not in a valid position!";
		}
		
		return "";
	}
	
	
	public static String validatePassword(String password, String password_again){
		if(password.length()<6){
			return "The password must be at least 6 characters long!";
		}
		if(!password.equals(password_again)){
			return "The two password fields do not match!";
		}
		return "";
	}

	public Memberinfo(){}
	
	public Memberinfo(String userid, String email, String password, String name, String address, String phonenum, Role role) throws NoSuchAlgorithmException {
		this.userid = userid;
		this.email = email;
		this.name = name;
		this.address = address;
		this.phonenum = phonenum;
		this.role = role;
		
		//PasswordHandler pwh = new PasswordHandler(password);
		
		this.password =  password;
		//this.salt = "abc".getBytes();
		this.salt = "temp".getBytes();
		
		//boolean d = PasswordHandler.compare(this.password, "92FK567z", salt);
	}
	
	
}
