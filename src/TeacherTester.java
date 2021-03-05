import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.Student;
import model.Teacher;

/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */

/**
 * @author Traee
 *
 */
public class TeacherTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Teacher susan = new Teacher("Susan");
		ListDetailsHelper ldh = new ListDetailsHelper();
		Student bill = new Student("Bill", "22");
		Student bob = new Student("Bob", "21");
		List<Student> susansStudents = new ArrayList<Student>();
		susansStudents.add(bill);
		susansStudents.add(bob);
		ListDetails susansList = new ListDetails("Susan's StudentList", LocalDate.now(), susan);
		susansList.setListOfStudents(susansStudents);
		ldh.insertNewListDetails(susansList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}	
	}
}

