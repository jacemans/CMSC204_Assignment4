import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**
 * Implements a hash table with buckets as an array of linked lists of CourseDBElements.
 * Each CDE has a hash code that comes from the CRN.
 * 
 * @author Justin Hixson
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	private int tableSize;

	protected LinkedList<CourseDBElement>[] hashTable;
	/**
	 * Default constructor
	 */
	public CourseDBStructure() {
		this.tableSize = 20;
		hashTable = new LinkedList[this.tableSize];
	}
	/**
	 * Constructor for CourseDBStructure
	 * @param tableSize the size of the hash table
	 */
	public CourseDBStructure(int tableSize) {
		this.tableSize = tableSize;
		hashTable = new LinkedList[this.tableSize];
	}
	/**
	 * Constructor for CourseDBStructure with testing string
	 * @param test testing string
	 * @param tableSize the size of the hash table
	 */
	public CourseDBStructure(String test, int tableSize) {
		this.tableSize = tableSize;
		hashTable = new LinkedList[this.tableSize];
	}

	@Override
	public void add(CourseDBElement element) {
		int hash = element.hashCode() % getTableSize();

		if(hashTable[hash] != null) 
			hashTable[hash].add(element);
		else {
			hashTable[hash] = new LinkedList<CourseDBElement>();
			hashTable[hash].add(element);
		}
	}
	/** 
	 * Use the hashcode of the CourseDatabaseElement to see if it is 
	 * in the hashtable.
	 * 
	 * If the CourseDatabaseElement is in the hashtable, return it
	 * If not, throw an IOException
	 * 
	 * @param crn the CRN to get
	 * @return the CourseDBElement at the CRN
	 * @throws IOException 
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		for (int i = 0 ; i < getTableSize() ; i++) {
			if(hashTable[i] == null)
				continue;

			LinkedList<CourseDBElement> list = hashTable[i];

			for (int j = 0 ; j < list.size() ; j++) {
				if (list.get(j).getCRN() == crn) {
					return list.get(j);
				}
			}
		}
		throw new IOException();
	}
	/**
	 * Adds all CourseDBElement strings to an array list
	 * @return array list of CourseDBElement strings
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i < getTableSize(); i++)
		{
			if(hashTable[i] != null)
			{
				LinkedList<CourseDBElement> list = hashTable[i];
				for(CourseDBElement cde : list)
				{
					String cdeString = "\n" + cde.toString();
					array.add(cdeString);
				}
			}
		}
		Collections.sort(array);
		return array;
	}
	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	 * @return the size of the ConcordanceDataStructure
	 */
	@Override
	public int getTableSize() {
		return tableSize;
	}

}
