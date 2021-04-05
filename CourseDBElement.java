package project4;

public class CourseDBElement implements Comparable{
	private String courseID;
	private String roomNum;
	private String instructor;
	private int crn;
	private int credits;
	
	public CourseDBElement() {
		courseID = null;
		roomNum = null;
		instructor = null;
		crn = 0;
		credits = 0;	
	}
	
	public CourseDBElement(String courseID, int crn, int credits, String roomNum, String instructor) {
		this.courseID = courseID;
		this.roomNum = roomNum;
		this.instructor = instructor;
		this.crn = crn;
		this.credits = credits;
	}
	
	public void setCRN(int input) {
		crn = input;
	}
	
	public int getCRN() {
		return crn;
	}
	
	public int hashCode() {
		String code = Integer.toString(crn);
		return code.hashCode();
	}
	
	public int compareTo(CourseDBElement element) {
		return this.compareTo(element);
	}
	
	public String toString() {
		return ("\nCourse:"+ courseID + " CRN:" + crn + " Credits:"+ credits + " Instructor:"+ instructor +" Room:" + roomNum);
	}
}
