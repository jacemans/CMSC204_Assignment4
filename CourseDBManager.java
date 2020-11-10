import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Allows the user to read the courses from a file or to enter the data by hand.
 * The input is read from a file or read from the text fields and is added to the data structure through the add method.
 * 
 * @author Justin Hixson
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	private final String FILE = "E:\\Jace\\Desktop\\java\\Assignment4\\src\\courses.txt";

	CourseDBStructure cds = new CourseDBStructure();
	CourseDBElement cde = new CourseDBElement();

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde =  new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		} catch (java.io.IOException e) {
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scan = new Scanner(new java.io.FileInputStream(FILE));
		while (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		scan.close();
	}

	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}
}
