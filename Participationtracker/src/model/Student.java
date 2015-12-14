package model;

public class Student extends Memberinfo {
	//Constructor
		public Student(Memberinfo memberinfo){
			this.id = memberinfo.id;
			this.email = memberinfo.email;
			this.name= memberinfo.name;
			this.password = memberinfo.password;
			this.phonenum = memberinfo.phonenum;
			this.address = memberinfo.address;
			this.userid = memberinfo.userid;
			this.password = memberinfo.password;
			
		}
		
		public	String registerToCourse(Course course){
			return null;
		}
		public	String markPariticapation(Session session){
			return null;
		}
		public	float showParticipationRate(){
			return 0;
		}
		public	float calculateParticipationRate(Course course){
			return 0;
		}
		
}
