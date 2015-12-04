package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private String salt;
	   
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

	public String getSalt() {
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
		//return role;
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	
	public static String validatePassword(String password){
		if(password.length()<6){
			return "The password must be at least 6 characters long!";
		}
		return "";
	}

	public Memberinfo(){}
	
	public Memberinfo(String userid, String email, String password, String name, String address, String phonenum){
		this.userid = userid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phonenum = phonenum;
	}
	
	
}
