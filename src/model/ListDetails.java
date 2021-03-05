/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Traee
 *
 */
@Entity
@Table(name="teacher_list")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="TEACHER_ID")
	private Teacher teacher;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="students_on_list",
		joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
		inverseJoinColumns={ @JoinColumn(name="STUDENT_ID", referencedColumnName="ID", unique=true) })
	private List<Student> listOfStudents;
	public ListDetails() {
		super();
	}
	public ListDetails(int id, String listName, LocalDate tripDate, Teacher teacher, List<Student> listOfStudents) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.teacher = teacher;
		this.listOfStudents = listOfStudents;
	}
	public ListDetails(String listName, LocalDate tripDate, Teacher teacher, List<Student> listOfStudents) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.teacher = teacher;
		this.listOfStudents = listOfStudents;
	}
	public ListDetails(String listName, LocalDate tripDate, Teacher teacher) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.teacher = teacher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getListOfStudents() {
		return listOfStudents;
	}
	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", teacher=" + teacher
				+ ", listOfStudents=" + listOfStudents + "]";
	}

}
