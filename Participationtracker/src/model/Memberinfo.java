package model;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int id;
	
	@Column(name = "userid", nullable = false)
	private String userid;

	@Column(name = "email", nullable = false)
	private String email;
	   
	@Column(name = "password", nullable = false)
	private String password;
	   
	@Column(name = "salt", nullable = false)
	private byte[] salt;
	   
	@Column(name = "name", nullable = false)
	private String name;
	   
	@Column(name = "address")
	private String address;
	   
	@Column(name = "phonenum")
	private String phonenum;
	   
	@ManyToOne(targetEntity=Role.class)
	@JoinColumn(name="role_id")
	private Role role;

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
	
	public static List<Memberinfo> getMemberinfos(){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Memberinfo.class);
		cfg.addAnnotatedClass(Role.class);
		cfg.configure("/resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		List<Memberinfo> members = session.createQuery("FROM memberinfo").list();
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
		
		//boolean d = PasswordHandler.compare(this.password, "92FK567z", salt);
	}
	
	
}
