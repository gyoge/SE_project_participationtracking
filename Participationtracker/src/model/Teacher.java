package model;

import java.util.Date;

public class Teacher extends Memberinfo {
	//Constructor
		public Teacher(Memberinfo memberinfo){
			this.id = memberinfo.id;
			this.email = memberinfo.email;
			this.name = memberinfo.name;
			this.password = memberinfo.password;
			this.phonenum = memberinfo.phonenum;
			this.address = memberinfo.address;
			this.userid = memberinfo.userid;
			this.password = memberinfo.password;
			
		}
		
		public String addCourse(String name, String courseid, String description, Date startdate){
			return null;
		}
		
		public String addSession(Date dateTime, Course course, String description){
			return null;
		}
}
