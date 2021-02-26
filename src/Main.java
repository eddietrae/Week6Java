import java.util.List;
import java.util.Scanner;

import controller.StudentHelper;
import model.Student;

/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Feb 11, 2021
 */

/**
 * @author Traee
 *
 */
public class Main {
	static Scanner in = new Scanner(System.in);
	static StudentHelper sh = new StudentHelper();
	
	private static void addAnItem() {
		
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter an age: ");
		int age = in.nextInt();
		Student toAdd = new Student(name, age);
		sh.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the age to delete: ");
		int age = in.nextInt();
		Student toDelete = new Student(name, age);
		sh.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Age");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Student> foundStudents;
		if (searchBy == 1) {
			System.out.print("Enter the student name: ");
			String name = in.nextLine();
			foundStudents = sh.searchForStudentByName(name);
		} else {
			System.out.print("Enter the student age: ");
			int age = in.nextInt();
			foundStudents = sh.searchForStudentByAge(age);
		}

		if (!foundStudents.isEmpty()) {
			System.out.println("Found Results.");
			for (Student s : foundStudents) {
				System.out.println(s.getId() + " : " + s.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Student toEdit = sh.searchForStudentById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " Age: " + toEdit.getAge());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Age");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Age: ");
				int newAge = in.nextInt();
				toEdit.setAge(newAge);
			}

			sh.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}
	public static void main(String[] args) {
		boolean goAgain = true;
		System.out.println("Welcome!");
		while (goAgain) {
			System.out.println("Select an item:");
			System.out.println("1 -- Add a student");
			System.out.println("2 -- Edit a student");
			System.out.println("3 -- Delete a student");
			System.out.println("4 -- View the list of students");
			System.out.println("5 -- Exit");
			System.out.print("Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				sh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
		
	private static void viewTheList() {
		List<Student> allStudents = sh.showAllStudents();
		for(Student s : allStudents){
		System.out.println(s.returnStudentDetails());
		}
	}
	
	

}
