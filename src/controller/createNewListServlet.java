package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentHelper sh = new StudentHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String teacherName = request.getParameter("teacherName");
		LocalDate ld;
		try{
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedStudents = request.getParameterValues("allStudentsToAdd");
		List<Student> selectedStudentsInList = new ArrayList<Student>();
		//make sure something was selected –otherwise we get a null pointer exception
		if (selectedStudents != null && selectedStudents.length > 0) {
			for(int i = 0; i<selectedStudents.length; i++) {
				System.out.println(selectedStudents[i]);
				Student c = sh.searchForStudentById(Integer.parseInt(selectedStudents[i]));
				selectedStudentsInList.add(c);
				}
			}
		Teacher teacher = new Teacher(teacherName);
		ListDetails sld = new ListDetails(listName, ld, teacher);
		sld.setListOfStudents(selectedStudentsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);System.out.println("Success!");
		System.out.println(sld.toString());getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
