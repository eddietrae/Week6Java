/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Traee
 *
 */
@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEACHER_ID")
	private int id;
	@Column(name="TEACHER_NAME")
	private String teacherName;
	public Teacher() {
		super();
	}
	public Teacher(int id, String teacherName) {
		super();
		this.id = id;
		this.teacherName = teacherName;
	}
	public Teacher(String teacherName) {
		super();
		this.teacherName = teacherName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherName=" + teacherName + "]";
	}
	
}
