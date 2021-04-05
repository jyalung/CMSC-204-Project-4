package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure cdbs = new CourseDBStructure(20);

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cdbs.add(newElement);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return cdbs.get(crn);
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner fileData = new Scanner(input);
			while(fileData.hasNext()) {
				String id = fileData.next();
				int crn = fileData.nextInt();
				int numCredits = fileData.nextInt();
				String roomNum = fileData.next();
				String instructor = fileData.nextLine();
				add(id, crn, numCredits, roomNum, instructor);
			}
			fileData.close();
		}
		catch(FileNotFoundException e) {
			System.out.print("File not found");
			e.getMessage();
		}
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < cdbs.hashTable.length; i++) { // loop through hashTable
			LinkedList<CourseDBElement> temp = cdbs.hashTable[i];
			if(temp != null) {
				for(int j = 0; j < temp.size(); j++) { // loop through buckets
					CourseDBElement element = temp.get(j);
					list.add(element.toString());
				}
			}
		}
		return list;
	}

}