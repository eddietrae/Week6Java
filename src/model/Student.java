/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Feb 11, 2021
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
@Table(name="student")
public class Student {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="ID")
		private int id;
		@Column(name="NAME")
		private String name;
		@Column(name="AGE")
		private int age;
		
		public Student(){
			super();
		}
		
		public Student(String name, int age){
			super();
			this.name = name;
			this.age = age;
		}
		public Student(String name, String age){
			super();
			this.name = name;
			this.age = Integer.parseInt(age);
		}

		public String returnStudentDetails() {
			return name + ": " + age;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
}
