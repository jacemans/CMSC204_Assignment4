/**
 * CourseDBElement consists of five attributes: 
 * the Course ID, the CRN, the number of credits, the room number, and the instructor name.
 * 
 * 
 * @author Justin Hixson
 *
 */
public class CourseDBElement implements Comparable{

	private String id, roomNum, instructor, hashcode;
	private int crn, credits;
	/**
	 * CourseDBElement default constructor
	 */
	public CourseDBElement() {
		id = null;
		crn = 0;
		credits = 0;
		roomNum = null;
		instructor = null;
		hashcode = hashcode();
	}
	/**
	 * CourseDBElement constructor
	 * @param id the course ID
	 * @param crn the CRN
	 * @param credits the credit hours
	 * @param roomNum the room number
	 * @param instructor the instructor
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.credits = credits;
		this.crn = crn;
		this.roomNum = roomNum;
		this.instructor = instructor;
		hashcode = hashcode();
	}
	/**
	 * Gets the ID
	 * @return the ID
	 */
	public String getID() {
		return id;
	}
	/**
	 * Sets the ID
	 * @param id the ID
	 */
	public void setID(String id) {
		this.id = id;
	}
	/**
	 * Gets the CRN
	 * @return the CRN
	 */
	public int getCRN() {
		return crn;
	}
	/**
	 * Sets the CRN
	 * @param crn the CRN
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	/**
	 * Gets the credit hours
	 * @return the credit hours
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * Sets the credit hours
	 * @param credits the credit hours
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	/**
	 * Gets the room number
	 * @return the room number
	 */
	public String getRoomNum() {
		return roomNum;
	}
	/**
	 * Sets the room number
	 * @param roomNum the room number
	 */
	public void setRoom(String roomNum) {
		this.roomNum = roomNum;
	}
	/**
	 * Gets the instructor
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * Sets the instructor
	 * @param instructor the instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/**
	 * Hash code for the CRN
	 * @return the hash code
	 */
	public String hashcode()
	{
		return "" + (("" + crn).hashCode());
	}

	@Override
	public int compareTo(CourseDBElement element) {
		if (crn < element.getCRN())
			return -1;
		else if (crn > element.getCRN())
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "Course:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
	}

}
