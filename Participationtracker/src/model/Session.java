package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "session")
public class Session {
	
	//variable declaration 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="date", nullable = false)
	private Date dateTime;
	
	@Column(name="duration", nullable = false)
	private int duration;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@ManyToOne(targetEntity=Course.class)
	@JoinColumn(name = "courseid", nullable = false)
	private Course course;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "memberinfo_has_session", joinColumns = { 
			@JoinColumn(name = "session_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "memberinfo_id", 
					nullable = false, updatable = false) })
	private Set<Memberinfo> members;
	
	// Here we declare get and set method for the variables 
	public int getId() {
		return id;
	}
	
	public Date getDate(){
		return dateTime;
	}
	
	public void setDate(Date dateTime){
		this.dateTime = dateTime;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public void setDuration(int duration){
		this.duration = duration;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public Course getCourse_id(){
		return course;
	}
	
	public void setCourse_id(Course course){
		this.course = course;
	}
	
	public Set<Memberinfo> getMembers() {
		return members;
	}

	public void setMembers(Set<Memberinfo> members) {
		this.members = members;
	} 
	
	//Default constructor for Session class
	public Session(){}
	
	// Constructor for Session class
	public Session( Date dateTime, int duration, String description, Course course){
		this.dateTime = dateTime;
		this.duration = duration;
		this.description = description;
		this.course = course;
	}
	
	//method to calculate attendance rate
	public float calculateAttendanceRate(){
		return 0;
		
		//Work under construction
	}
	
}