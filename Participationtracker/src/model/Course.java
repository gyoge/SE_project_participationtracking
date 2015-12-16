package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	//variable declaration 
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id", nullable = false)
		private int id;
	
		@Column(name="name")
		private String name;
		
		@Column(name="code")
		private String code;
		
		@Column(name="startdate", nullable = false)
		private Date startdate;
		
		@Column(name="description", nullable = false)
		private String description;
		
		@ManyToOne(targetEntity=Memberinfo.class)
		@JoinColumn(name="teacherid")
		private Memberinfo teacher;
		
		@OneToMany(mappedBy="course")
		private Set<model.Session> sessions;
		
		// Here we declare get and set method for the variables 
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getCode(){
			return code;
		}
		
		public Date getDate(){
			return startdate;
		}
		
		public void setDate(Date startdate){
			this.startdate = startdate;
		}
		
		public String getDescription(){
			return description;
		}
		
		public void setDescription(String description){
			this.description = description;
		}
		
		public Memberinfo getTeacher(){
			return teacher;
		}
		
		public Set<Session> getSession(){
			return sessions;
		}
		
		public void setSession(Set<Session> sessions) {
			this.sessions = sessions;
		}
		
		//default constructor
		public Course(){}
		
		public Course(String name, String code, Date date, String description, Memberinfo teacher){
			this.name = name;
			this.code = code;
			this.startdate = date;
			this.description = description;
			this.teacher = teacher;
		}
		
		public	String addStudent(Student student){
			return "";
		}
		public	String addSession(Session session){
			return "";
		}
		public	float calculateParticipationRate(){
			return 0;
		}
		public	float calculateParticipationRate(Student student){
			return 0;
		}
}